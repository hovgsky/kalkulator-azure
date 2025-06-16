package azure.Kalkulator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin // jeśli frontend jest osobno
public class KalkulatorController {

    @PostMapping("/calculate")
    public double calculate(@RequestBody CalculationRequest request) {
        Expression expression = new ExpressionBuilder(request.getExpression()).build();
        return expression.evaluate();
    }
}
