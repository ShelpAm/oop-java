package shelpam.week8;

class PlanA {
  public static class SuperHero {
    private static int numOfTanya = 0;
    private static int numOfIvan = 0;
    private static final int maxNumOfSuperHeroes = 1;

    private final String name;

    public static SuperHero makeTanya() {
      if (numOfTanya == maxNumOfSuperHeroes) {
        return null;
      }
      ++numOfTanya;
      return new SuperHero("Tanya");
    }

    public static SuperHero makeIvan() {
      if (numOfIvan == maxNumOfSuperHeroes) {
        return null;
      }
      ++numOfIvan;
      return new SuperHero("Ivan");
    }

    private SuperHero(String name) {
      this.name = name;
    }

    public String name() {
      return this.name;
    }
  }
}

class PlanB {
  public static class SuperHero {
    private static int numOfSuperHeroes = 0;
    private static final int maxNumOfSuperHeroes = 1;

    private final String name;

    public static SuperHero makeTanya() {
      return fromName("Tanya");
    }

    public static SuperHero makeIvan() {
      return fromName("Ivan");
    }

    private static SuperHero fromName(String name) {
      if (numOfSuperHeroes == maxNumOfSuperHeroes) {
        return null;
      }
      ++numOfSuperHeroes;
      return new SuperHero(name);
    }

    private SuperHero(String name) {
      this.name = name;
    }

    public String name() {
      return this.name;
    }
  }
}
