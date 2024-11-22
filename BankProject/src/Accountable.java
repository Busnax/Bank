public interface Accountable {
    // isCredit verifica che l'acconto sia in credito o in debito
    boolean isCredit();
    // getAmount determina la cifra da accereditare/prelevare da un conto
    double getAmount();
}
