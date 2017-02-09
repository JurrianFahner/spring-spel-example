package nl.ensignprojects;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ensignprojects.model.Car;
import nl.ensignprojects.model.PropertiesExample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * @author jurrian
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    
    private final PropertiesExample pe;
    
    @Override
    public void run(String... args) throws Exception {

        ExpressionParser expressionParser = new SpelExpressionParser();
        
        Expression expression = expressionParser.parseExpression("'Any string'");
        String strResult = (String) expression.getValue();        
        log.debug("Spel test: {}", strResult);
        
        expression = expressionParser.parseExpression("'Any string'.length()-5");
        int intResult = (Integer) expression.getValue();        
        log.debug("Length: {}", intResult);
        

        Car car = new Car();
        StandardEvaluationContext context = new StandardEvaluationContext(car);
        
        List<String> spel =  pe.getSpel();

        //apply spring expression language
        spel.forEach(c -> expressionParser.parseExpression(c).getValue(context));
        
        log.debug("{}", car);
        
        log.debug("#rules: {}", spel.size());
                
    }
    
}
