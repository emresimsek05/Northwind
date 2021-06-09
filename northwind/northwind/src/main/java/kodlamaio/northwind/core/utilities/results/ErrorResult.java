package kodlamaio.northwind.core.utilities.results;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties;

public class ErrorResult extends Result{
    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false,message);
    }
}
