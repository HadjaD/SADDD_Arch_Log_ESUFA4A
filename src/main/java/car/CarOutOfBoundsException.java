package car;

class CarOutOfBoundsException extends RuntimeException {

    public CarOutOfBoundsException() {
        super("Le Véhicule ne peut pas être hors des limites de la Surface !!!");
    }
}
