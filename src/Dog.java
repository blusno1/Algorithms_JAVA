
public class Dog {

    private interface Pet {
        void beFriendly();

        void play();
    }

    static abstract class Ball {
        abstract String getName();
    }

    private void play(Ball b) {
        System.out.println(b.getName());
    }

    public static void main(String[] args) {
        Pet dog = new Pet() {
            @Override
            public void beFriendly() {
                System.out.println("蹭蹭你^_^");
            }

            @Override
            public void play() {
                System.out.println("把飞盘叼给你，逼你把飞盘丢出去，然后它再捡回来让你继续扔，连续500次^_^");
            }
        };

        dog.beFriendly();
        dog.play();

        Dog dog1 = new Dog();

        dog1.play(new Ball() {
            @Override
            String getName() {
                return "qiu qiu";
            }
        });
    }

}
