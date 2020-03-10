package aepveiculos;

import java.util.Date;

public class AEPveiculos {

    public static void main(String[] args) {

    }

    public class PassagemVeiculo {

        private int cod;
        private Date data;
        private String marca, matricula;

        public PassagemVeiculo(int c) {
            cod = c;
            data = new Date();
        }

        public void setDate(Date d) {
            data = d;
        }

        public void setMarca(String m) {
            marca = m;
        }

        public int getCod() {
            return cod;
        }

        public String getMarca() {
            return marca;
        }
    }

    public class Passagem extends PassagemVeiculo {

        private int euros;

        public Passagem(int c) {
            super(c);
        }

        public void setEuros(int e) {
            euros = e;
        }

        public int getEuros() {
            return euros;
        }
    }

    public class Portico {

        private int id = 0;
        private PassagemVeiculo[] veiculo;

        public Portico() {
            veiculo = new PassagemVeiculo[1000];
        }

        public void passagens(PassagemVeiculo pv) {
            if (procura(pv.getCod())) {
                veiculo[id] = pv;
                id++;
            } else {
                System.out.println("ERRO!");
            }

        }

        private boolean procura(int c) {
            for (int i = 0; i < veiculo.length; i++) {
                if (veiculo[i].getCod() == c) {
                    return true;
                }
            }
            return false;
        }

        public int pesadoMarca(String marca) {
            int ct = 0;
            for (int i = 0; i < id; i++) {
                if (veiculo[i] instanceof Passagem) {

                    if (veiculo[i].getMarca().equals(marca)){
                    ct++;
                    }
                }
            }
            return ct;
        }

    }
}
