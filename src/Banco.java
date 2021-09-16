import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
    	Gerente gerente1 = new Gerente();
    	gerente1.setSalarioGerente(1000);
    	System.out.println("Salario inicial do gerente: R$"+gerente1.getSalarioGerente());
    	System.out.println("Digite 1 para 10% ou um numero qualquer para 50%");
    	Scanner teclado = new Scanner(System.in);
    	int num = teclado.nextInt();
    	if (num == 1) {
    		gerente1.aumentoSalarial();
        	System.out.println("Novo salario do gerente: R$"+gerente1.getSalarioGerente());
    	}else {
    		gerente1.aumentoSalarial(50);
        	System.out.println("Novo salario do gerente: R$"+gerente1.getSalarioGerente());
    	}
    	
    	System.out.println("---------------------------------------------------");

    	Agencia a = new Agencia(9876);
    	Agencia b = new Agencia(1234);

    	Conta origem = new Conta(a);
    	origem.setSaldo(2000);;
    	System.out.println("Saldo da primeira conta: R$"+ origem.getSaldo());
    	
    	Conta destino = new Conta(b);
    	destino.setSaldo(1000);;
    	System.out.println("Saldo da segunda conta: R$"+ destino.getSaldo());

    	System.out.println("---------------------------------------------------");
    	
    	System.out.println("Realizando a transferencia");
    	origem.transfere(destino, 200);
    	
    	System.out.println("---------------------------------------------------");

    	System.out.println("Saldo da primeira conta: R$"+ origem.getSaldo());
    	System.out.println("Saldo da segunda conta: R$"+ destino.getSaldo());
    	
    	System.out.println("---------------------------------------------------");

    	Funcionario funcionario1 = new Funcionario();
    	funcionario1.setNomeFuncionario("José");
    	funcionario1.setSalarioFuncionario(1000);
    	Funcionario.valeRefeicaoDiario = 15;
    	
    	System.out.println("O funcionario: "+funcionario1.getNomeFuncionario()+" tem o salario de: R$"+funcionario1.getSalarioFuncionario());
    	System.out.println("Ele tambem recebe: R$"+Funcionario.valeRefeicaoDiario+" de VR diario");
    	
    	Funcionario.aumentoValeRefeicao(50);
    	
    	System.out.println("O aumento do VR foi para: R$"+Funcionario.valeRefeicaoDiario);



    }
}

class Pessoa {
    private String rg;
    private int cpf;

    public Pessoa(String rg){
        this.rg = rg;
    }

    public Pessoa(int cpf){
        this.cpf = cpf;
    }
}
class Conta {
    private Agencia agencia;
    private double saldo;
    private double limite;
    
    public double getSaldo() {
    	return this.saldo;
    }
    public void setSaldo(double saldo) {
    	this.saldo = saldo;
    }

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
	private int numero;
    public CartaoDeCredito(int numero) {
    	this.numero = numero;
    }
}
class Agencia {
	private int numero;
    public Agencia(int numero) {
    	this.numero = numero;
    }
}
class Gerente{
	private double salarioGerente;
	private String nomeGerente;
	
	public double getSalarioGerente() {
		return this.salarioGerente;
	}
	
	public void setSalarioGerente(double salarioGerente) {
		this.salarioGerente = salarioGerente;
	}
	
	public void aumentoSalarial() {
		this.aumentoSalarial(10);
	}
	public void aumentoSalarial(double taxaVariavel) {
		this.salarioGerente += (this.salarioGerente * (taxaVariavel/100));
	}
}
class Funcionario{
	private String nomeFuncionario;
	private double salarioFuncionario;
	public static double valeRefeicaoDiario;
	
	public String getNomeFuncionario() {
		return this.nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public double getSalarioFuncionario() {
		return this.salarioFuncionario;
	}
	public void setSalarioFuncionario(double salarioFuncionario) {
		this.salarioFuncionario = salarioFuncionario;
	}
	
	static void aumentoValeRefeicao(double taxaVariavel) {
		Funcionario.valeRefeicaoDiario += (Funcionario.valeRefeicaoDiario * (taxaVariavel/100));
	}
}
