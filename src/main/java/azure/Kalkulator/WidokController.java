package azure.Kalkulator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WidokController {

    private final List<String> historia = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        model.addAttribute("dzialanie", "");
        model.addAttribute("historia", historia);
        return "index"; // templates/index.html
    }

    @PostMapping("/oblicz")
    public String oblicz(@RequestParam String dzialanie, Model model) {
        String wynik;
        try {
            Expression expression = new ExpressionBuilder(dzialanie).build();
            double result = expression.evaluate();
            wynik = dzialanie + " = " + result;
        } catch (Exception e) {
            wynik = dzialanie + " = BŁĄD";
        }

        historia.add(0, wynik);
        model.addAttribute("dzialanie", dzialanie);
        model.addAttribute("historia", historia);
        return "index";
    }
}
