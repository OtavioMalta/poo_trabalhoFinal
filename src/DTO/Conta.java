package DTO;
import java.util.ArrayList;
import java.util.Date;

import Util.ManipularArquivo;

public abstract class Conta implements ManipularArquivo{
    protected ArrayList<Integer> clientes;
    protected long idAgencia;
    protected Date criacao;
    protected double saldo;
    protected ArrayList<Long> idRegistros;
    protected long id;
    
    private static long IDConta = System.nanoTime();

    public Conta() {
    }
 
    public Conta( long idAgencia, double saldo) {
        
        this.idAgencia = idAgencia;
        this.criacao = new Date();
        this.saldo = saldo;
        this.idRegistros = new ArrayList<>();
        this.id = Conta.IDConta++;
        this.clientes = new ArrayList<>();
    }
    public Conta( long idAgencia, double saldo, Date criacao) {
        
        this.idAgencia = idAgencia;
        this.criacao = criacao;
        this.saldo = saldo;
        this.idRegistros = new ArrayList<>();
        this.id = Conta.IDConta++;
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Integer> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Integer> cliente) {
        this.clientes = cliente;
    }

    public long getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(long idAgencia) {
        idRegistros.add(new Registro(this.saldo,this.id).getId());
        this.idAgencia = idAgencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Long> getIdRegistro() {
        return this.idRegistros;
    }

    public Date getCriacao() {
        return this.criacao;
    }
    
    public long getId() {
        return this.id;
    }

    public void atribuirCliente(int cliente){
        clientes.add(cliente);
    }

    public void atribuirCliente(ArrayList<Integer> clientes){
        for(Integer c : clientes){
            this.clientes.add(c);
        }
    }

    public ArrayList<Long> getRegistros() {
        return this.idRegistros;
    }
}
