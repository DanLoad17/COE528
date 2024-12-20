/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author zelen
 */
class Member extends Passenger {
        int yearOfMembership;

    public Member(String n, int a) {
        super(n, a);
    }

        @Override
        double applyDiscount(double p) {
                if (yearOfMembership > 5)
                        return p * 0.5;
                if (yearOfMembership > 1)
                        return p * 0.9;
                return p;
        }
    public int getYearsOfMembership() {
      return yearOfMembership;
   }

   public void setYearOfMembership(int yearOfMembership) {
      this.yearOfMembership = yearOfMembership;
   }
}
