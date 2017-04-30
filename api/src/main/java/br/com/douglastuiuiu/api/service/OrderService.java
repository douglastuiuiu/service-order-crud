package br.com.douglastuiuiu.api.service;

import br.com.douglastuiuiu.api.exception.AlreadyReportedException;
import br.com.douglastuiuiu.api.exception.NotFoundException;
import br.com.douglastuiuiu.api.exception.ServiceException;
import br.com.douglastuiuiu.api.model.document.Order;
import br.com.douglastuiuiu.api.model.dto.OrderDTO;
import br.com.douglastuiuiu.api.util.MessageLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private MessageLocale messageLocale;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id
     * @return OrderDTO
     * @throws ServiceException
     */
    public OrderDTO findById(String id) throws ServiceException {
        try {
            Order order = mongoTemplate.findById(id, Order.class);
            if (order == null) {
                logger.error(messageLocale.getMessage("error.order_not_found"), id);
                throw new NotFoundException(messageLocale.getMessage("error.order_not_found"));
            }
            return OrderDTO.parseOrderDTO(order);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage(), e);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @param id
     * @throws ServiceException
     */
    public void delete(String id) throws ServiceException {
        try {
            Order order = mongoTemplate.findById(id, Order.class);
            if (order == null) {
                logger.error(messageLocale.getMessage("error.order_not_found"), id);
                throw new NotFoundException(messageLocale.getMessage("error.order_not_found"));
            }
            mongoTemplate.remove(order);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage(), e);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @throws ServiceException
     */
    public List<OrderDTO> findAll() throws ServiceException {
        try {
            List<Order> list = mongoTemplate.findAll(Order.class);
            return list.stream().filter(Objects::nonNull).map(OrderDTO::parseOrderDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @param orderDTO
     * @throws ServiceException
     */
    public OrderDTO create(OrderDTO orderDTO) throws ServiceException {
        try {
            orderDTO.setFinished(Boolean.FALSE);
            orderDTO.setCreateAt(LocalDateTime.now());
            orderDTO.setUpdateAt(null);
            Order order = Order.parseOrder(orderDTO);

            mongoTemplate.save(order);
            return OrderDTO.parseOrderDTO(order);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @param id
     * @throws ServiceException
     */
    public void finish(String id) throws ServiceException {
        try {
            Order order = mongoTemplate.findById(id, Order.class);
            if (order == null) {
                logger.error(messageLocale.getMessage("error.order_not_found"), id);
                throw new NotFoundException(messageLocale.getMessage("error.order_not_found"));
            }
            if (order.getFinished()) {
                logger.error(messageLocale.getMessage("error.order_already_finished"), id);
                throw new AlreadyReportedException(messageLocale.getMessage("error.order_already_finished"));
            }
            order.setFinished(Boolean.TRUE);
            mongoTemplate.save(order);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage(), e);
        } catch (AlreadyReportedException e) {
            throw new AlreadyReportedException(e.getMessage(), e);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
