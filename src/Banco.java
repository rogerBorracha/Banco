import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
    	Gerente gerente1 = new Gerente();
    	gerente1.salarioGerente = 1000;
    	System.out.println("Salario inicial do gerente: "+gerente1.salarioGerente);
    	System.out.println("Digite 1 ou 2");
    	Scanner teclado = new Scanner(System.in);
    	int num = teclado.nextInt();
    	if (num == 1) {
    		gerente1.aumentoSalarial();
        	System.out.println(gerente1.salarioGerente);
    	}else {
    		gerente1.aumentoSalarial(50);
        	System.out.println(gerente1.salarioGerente);
    	}
    	Agencia a = new Agencia(9876);
    	Agencia b = new Agencia(1234);

    	Conta origem = new Conta(a);
    	origem.saldo = 1000;
    	System.out.println("Saldo da primeira conta: "+ origem.saldo);
    	
    	Conta destino = new Conta(b);
    	destino.saldo = 1000;
    	System.out.println("Saldo da segunda conta: "+ destino.saldo);

    	System.out.println("---------------------------------------------------");
    	
    	System.out.println("Realizando a transferencia");
    	origem.transfere(destino, 200);
    	
    	System.out.println("---------------------------------------------------");

    	System.out.println("Saldo da primeira conta: "+ origem.saldo);
    	System.out.println("Saldo da segunda conta: "+ destino.saldo);
    	
    	System.out.println("---------------------------------------------------");

    	Funcionario funcionario1 = new Funcionario();
    	funcionario1.nomeFuncionario = "José";
    	funcionario1.salarioFuncionario = 1000;
    	Funcionario.valeRefeicaoDiario = 15;
    	
    	System.out.println("O funcionario: "+funcionario1.nomeFuncionario+" tem o salario de: "+funcionario1.salarioFuncionario);
    	System.out.println("Ele tambem recebe: "+Funcionario.valeRefeicaoDiario+" de VR diario");
    	
    	Funcionario.aumentoValeRefeicao(50);
    	
    	System.out.println("O aumento do VR foi para: "+Funcionario.valeRefeicaoDiario);



    }
}

class Pessoa {
    public String rg;
    public int cpf;

    public Pessoa(String rg){
        this.rg = rg;
    }

    public Pessoa(int cpf){
        this.cpf = cpf;
    }
}
class Conta {
    public Agencia agencia;
    public double saldo;
    public double limite;

    public Conta(Agencia agencia) {
        this.agencia = agencia;
    }
    public Conta(Agencia agencia, double limite) {
        this.agencia = agencia;
        this.limite = limite;
    }
    void deposita(double valor){
        this.saldo += valor;
    }
    double exibeSaldoComLimite(){
        return this.saldo + this.limite;
    }
    void imprimeExtrato(){
        this.imprimeExtrato(15);
    }
    void imprimeExtrato(int dias){
        System.out.println("Extrato do últimos "+ dias +" dias");
    }
    public void transfere (Conta destino, double valor) {
    	this.saldo -= valor;
    	destino.saldo += valor;
    }
}
class CartaoDeCredito {
    public int numero;
    public CartaoDeCredito(int numero) {
    	this.numero = numero;
    }
}
class Agencia {
    public int numero;
    public Agencia(int numero) {
    	this.numero = numero;
    }
}
class Gerente{
	public double salarioGerente;
	public String nomeGerente;
	
	public void aumentoSalarial() {
		this.aumentoSalarial(10);
	}
	public void aumentoSalarial(double taxaVariavel) {
		this.salarioGerente += (this.salarioGerente * (taxaVariavel/100));
	}
}
class Funcionario{
	public String nomeFuncionario;
	public double salarioFuncionario;
	public static double valeRefeicaoDiario;
	
	static void aumentoValeRefeicao(double taxaVariavel) {
		Funcionario.valeRefeicaoDiario += (Funcionario.valeRefeicaoDiario * (taxaVariavel/100));
	}
}
