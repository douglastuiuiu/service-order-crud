package br.com.douglastuiuiu.api.resource;

import br.com.douglastuiuiu.api.exception.ServiceException;
import br.com.douglastuiuiu.api.model.dto.OrderDTO;
import br.com.douglastuiuiu.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "*")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> findById(@PathVariable("id") String id) throws ServiceException {
        OrderDTO order = orderService.findById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) throws ServiceException {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> findAll() throws ServiceException {
        List<OrderDTO> ordersDTO = orderService.findAll();
        return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> create(@Valid @RequestBody OrderDTO orderDTO) throws ServiceException {
        OrderDTO result = orderService.create(orderDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/finish", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> finish(@PathVariable("id") String id) throws ServiceException {
        orderService.finish(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}