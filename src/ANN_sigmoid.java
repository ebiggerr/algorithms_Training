import static java.lang.Math.exp;

public class ANN_sigmoid {

    public static void main(String [] args){

            //sigmoid function = 1/ (1 + exp(-z) )
            //z= summation [ x[i]W[i] ] + bias
            double []weights={-0.1,-0.2};

            double []inputs={1.3,0.5};

            double bias=(0.8)*(-0.1);

            double z= summation(weights,inputs) + bias;

            System.out.println(z);
            double node_value= 1/(1+ (exp(-z)) );
            System.out.println(node_value);
    }

    public static double summation(double[] weights, double[] inputs){
        
        double result = 0;
        for( int le=0; le < weights.length; le++){
            
            result += inputs[le] * weights[le];
            
        }
        
        return result;
    }
}
