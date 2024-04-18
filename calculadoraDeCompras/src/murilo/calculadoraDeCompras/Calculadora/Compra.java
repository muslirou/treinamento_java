package murilo.calculadoraDeCompras.Calculadora;

public class Compra {
    private String item;
    private double valorItem = 0;

    public String getItem() {
        return item;
    }

    public String setItem(String item) {
        this.item = item;
        return item;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public Compra(String item, double valorItem){
      this.item = item;
      this.valorItem = valorItem;
    }

    @Override
    public String toString() {
        return this.getItem() + " R$ " + this.getValorItem();
    }
}
