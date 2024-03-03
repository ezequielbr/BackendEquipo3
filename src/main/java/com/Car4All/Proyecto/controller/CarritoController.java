import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
    CarritoService carritoService;

    @GetMapping
    public String mostrarCarrito() {
        mostrarCarrito = carritoService.verDetalle();
        return "carrito";
    }

    @PostMapping("/agregarItem")
    public String agregarItemAlCarrito(@RequestParam Long autoId, @RequestParam int cantidad) {
        return "redirect:/carrito"; // Redirige de nuevo a la página del carrito
    }


    @PostMapping("/realizarPedido")
    public String realizarPedido() {
        return "redirect:/carrito";
    }
}