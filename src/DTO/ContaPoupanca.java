package DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;

public class ContaPoupanca extends Conta implements ManipularArquivo{
    private double juros;

    public ContaPoupanca( long idAgencia, double saldo, double juros) {
        super(idAgencia, saldo);
        this.juros = juros;
    }

    public double getJuros() {
        return this.juros;
    }

    public void setJuros(double juros) {
        Registro registro = new Registro(this.saldo, this.id);
        idRegistros.add(registro.getId());
        registro.salvar();
        this.juros = juros;
    }
    
    @Override
    public String toString() {
        return "{" +
            "clientes='" + getClientes() + "'" +
            "\nidAgencia='" + getIdAgencia() + "'" +
            "\ncriacao='" + getCriacao() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "\nregistros='" + getRegistros() + "'" +
            "\nid='" + getId() + "'" +
            "\njuros='" + getJuros() + "'" +
            "}\n";
    }

    @Override
    public ArrayList<ContaPoupanca> lista() {
        String path = "repository\\contaP.txt";		
		ArrayList<ContaPoupanca> list = new ArrayList<ContaPoupanca>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                ContaPoupanca contaPoupanca = new ContaPoupanca(Long.parseLong(texto[0]), Double.parseDouble(texto[1]),Double.parseDouble(texto[2]));
                list.add(contaPoupanca);
            }
        return list;
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            return list;
		}
	}

    @Override
    public void salvar() {
        try{
            String path = "repository\\contaP.txt";
            String texto = getIdAgencia() + "," +
            getSaldo() + "," +
            getJuros();
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    

    

    
}
