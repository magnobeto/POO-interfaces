
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PayPalService;

/**
 *
 * @author Roberto
 */
public class Program {
    
    public static void main(String[] args) throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();
        
        Contract contract = new Contract(number,date,totalValue);
        
        System.out.print("Enter number of installments: ");
        int months = sc.nextInt();
        
        ContractService cs = new ContractService(new PayPalService());
        cs.processContract(contract, months);
        
        System.out.println("Installments:");
        for (Installment inst : contract.getInstallments()){
            System.out.println(inst);
        }
        
        sc.close();
    }
}
