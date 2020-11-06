
package pizzalgh.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//@FeignClient(name="order", url="http://order:8080")//origin
//@FeignClient(name="order", url="http://localhost:8081")//local
@FeignClient(name="order", url="http://api.url.order:8080")
public interface OrderService {

    @RequestMapping(method= RequestMethod.POST, path="/orders")
    public void order(@RequestBody Order order);

}