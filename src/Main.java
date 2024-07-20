import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro sálario: ");
        double salario1 = scanner.nextDouble();
        System.out.print("Digite o segundo sálario: ");
        double salario2 = scanner.nextDouble();
        System.out.print("Digite o terceiro sálario: ");
        double salario3 = scanner.nextDouble();
        System.out.print("Digite o quarto sálario: ");
        double salario4 = scanner.nextDouble();
        System.out.print("Digite o quinto sálario: ");
        double salario5 = scanner.nextDouble();

        calcularSalario(salario1);
        calcularSalario(salario2);
        calcularSalario(salario3);
        calcularSalario(salario4);
        calcularSalario(salario5);

        scanner.close();
    }

    public static void calcularSalario(double salarioBruto){
        double inss = descontoInss(salarioBruto);
        double ir = impostoRenda(salarioBruto - inss);
        double salarioReceber = salarioBruto - inss - ir;

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("Salário bruto: " + salarioBruto);
        System.out.println("Valor pago de INSS: " + inss);
        System.out.println("Valor pago de Imposto de Renda: " + ir);
        System.out.println("Salário líquido: " + salarioReceber);
        System.out.println("+++++++++++++++++++++++++++++++++++");
    }

    public static double impostoRenda(double salarioBase){

        if(salarioBase <= 1903.98){
            return 0.0;
        }
        else if (salarioBase >= 1903.99 && salarioBase <= 2826.65){
            return (0.075F * salarioBase) - 142.80;
        } else if (salarioBase >= 2826.66 && salarioBase <= 3751.05) {
            return (0.15F * salarioBase) - 354.80;
        }
        else if(salarioBase >= 3751.06 && salarioBase <= 4664.68){
            return (0.225F * salarioBase) - 636.13;
        }
        else{
            return (0.275F * salarioBase) - 869.36;
        }
    }

    public static double descontoInss(double salario){
        if ( salario > 0 && salario <= 1212.00) {
            return salario * 0.075;
        } else if (salario >= 1212.01 && salario <= 2427.35) {
            return salario * 0.09;
        } else if (salario >= 2427.36 && salario <= 3641.03) {
            return salario * 0.12;
        } else{
            return salario * 0.14;
        }
    }
}

