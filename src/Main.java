public class Main {
    public static void main(String[] args) {
        VirtualPet pet = new VirtualPet("Garbage");
        System.out.println(pet.getAccountBalance());
        pet.gamble(Utility.Console.getNumericalInput(1, (int) pet.getAccountBalance()));
        System.out.println(pet.getAccountBalance());
    }
}
