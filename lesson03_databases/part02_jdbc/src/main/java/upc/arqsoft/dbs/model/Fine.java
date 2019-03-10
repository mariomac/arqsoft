package upc.arqsoft.dbs.model;

public class Fine {
    private int id;
    private String model;
    private String plate;
    private int euros;
    private boolean paid;

    public Fine(int id, String model, String plate, int euros, boolean paid) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.euros = euros;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }


    public String getModel() {
        return model;
    }


    public String getPlate() {
        return plate;
    }


    public int getEuros() {
        return euros;
    }


    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", euros=" + euros +
                ", paid=" + paid;
    }
}
