package ss7_lop_truu_tuong_va_interface.thuc_hanh.fruit;

public class FruitTest {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];
        {
            fruits[0] = new Orange();
            fruits[1] = new Apple();
            for (Fruit fruit : fruits) {
                System.out.println(fruit.howToEat());
            }
        }
    }
}
