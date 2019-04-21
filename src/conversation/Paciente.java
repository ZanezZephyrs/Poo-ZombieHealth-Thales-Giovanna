    
package conversation;
import interfaces.*;
import java.util.Random;

public class Patient implements IResponder {
    private int patientN = 0;
    private ITableProducer producer;
    private String attributes[];
    private String patientInstance[];
    
    public void receive(ITableProducer producer) {
        this.producer = producer;

        attributes = producer.requestAttributes();
        String instances[][] = producer.requestInstances();

        patientN = (int)(Math.random() * instances.length);
        patientInstance = instances[patientN];
        
        System.out.println("Patient selected: " + patientN);
        System.out.println("Patient's disease: " + patientInstance[attributes.length - 1]);
    }
    
    public String ask(String question) {
        String result;
        for (int a = 0; a < attributes.length - 1; a++)
            if (question.toLowerCase().contains(attributes[a])){
                if (patientInstance[a].equals("t")){
                    result = "yes";
                else if(patientInstance[a].equals("f")){
                    result = "no";
                }
                else{
                    result = "unknown";
                }
            }
        return result;
    }

    public boolean finalAnswer(String answer) {
        boolean result = false;
        if (answer.equalsIgnoreCase(patientInstance[attributes.length - 1]))
            result = true;
        return result;
    }
}
