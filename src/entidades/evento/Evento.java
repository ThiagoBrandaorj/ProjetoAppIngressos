package entidades.evento;

import java.time.LocalDate;

import entidades.ingresso.TipoIngresso;

public abstract class Evento {
    private String nome;
    private LocalDate data;
    private String local;
    private int ingressosMeia;
    private int ingressosInteira;
    private double precoCheio;


    public Evento(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira, double precoCheio) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosMeia = ingressosMeia;
        this.ingressosInteira = ingressosInteira;
        this.precoCheio = precoCheio;
    }

    public double getPrecoCheio() {
        return this.precoCheio;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIngressos() {
        return this.ingressosInteira + this.ingressosMeia;
    }



    public void setData(LocalDate data) {
        this.data = data;
    }



    public void setLocal(String local) {
        this.local = local;
    }


    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade) {
        if (tipo.equals(TipoIngresso.MEIA)) {
            return quantidade <= this.ingressosMeia;
        }

        return quantidade <= this.ingressosInteira;
    }

    public void venderIngresso(TipoIngresso tipo, int quantidade) {
        if (this.isIngressoDisponivel(tipo, quantidade)) {
            if (tipo.equals(TipoIngresso.MEIA)) {
                this.ingressosMeia -= quantidade;
            } else {
                this.ingressosInteira -= quantidade;
            }
        }
    }

    public void IngressosRestantes(){
       System.out.println("Existem" + " " + this.ingressosInteira + " " + "ingressos inteiros restantes para esse eveneto e " + " " + this.ingressosMeia + " " + "ingressos meia"); 
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.data + " - " + this.local;
    }
}