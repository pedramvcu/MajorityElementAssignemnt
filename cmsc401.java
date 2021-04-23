/* CMSC401
 * Professor: Dr.Bulut
 * Student: Pedram Maleki
 * Assignment 1
 *
 * This class Implement a variant of Majority Element which looks for
 * elements occurring more than N/3 times
 * If none exist -1 is printed*/

import java.util.Scanner;

public class cmsc401 {

    public static void main(String[] args){
        /*This variable holds the size of input*/
        int sizeN;
        Scanner in = new Scanner(System.in);
        sizeN=in.nextInt();
        /*Storing the input into an array of ints using a for loop*/
        int [] numbers = new int[sizeN];
        for(int i=0;i<sizeN;i++){
            numbers[i]=in.nextInt();
        }

        /*Calling the findCandidates and isMajority methods and storing the results into
        * the results array*/
        int [] results=isMajority(findCandidates(numbers,sizeN),numbers,sizeN);

        /*Formatting the output and printing--if no M.E exists -1 is printed*/
        if(results[0]==-1 &&results[1]==-1) System.out.println("-1");
        else if(results[0]==-1) System.out.println(results[1]);
        else if(results[1]==-1) System.out.println(results[0]);
        else if(results[0]==results[1]) System.out.println(results[0]);
        else {
            if(results[0]<results[1]){
                System.out.print(results[0]+" "+results[1]);
            }else{
                System.out.print(results[1]+" "+results[0]);
                System.out.println(results[0]+" "+results[1]+" else");
            }
        }


    }

    /**
     * This Method looks for candidates to be checked and see
     * if they are majority elemenet
     * returns an array of two elements with two candidates
     * @param numbers
     * @param sizeN
     * @return int array results
     */
    public static int[] findCandidates (int [] numbers, int sizeN){
        /*This stores the resulting candidates*/
        int [] candidates = new int[2];
        int counter1=1;
        int counter2=0;
        int mElementIndx1=0;
        int mElementIndx2=0;
        for(int i=1;i<sizeN;i++){
            /*If the number is the same as the previeous number, the counter for
            * previuos is incremented*/
            if(numbers[mElementIndx1]==numbers[i]){
                counter1++;
            }
            /*This checks to see if the second candidate is available*/
            else if(counter2==0){
                mElementIndx2=i;
                counter2=1;
            }
            /*if number is the same as candid 2 we increment the counter*/
            else if(numbers[mElementIndx2]==numbers[i]){
                counter2++;
            }
            /*If candid one is available we put the current number in this candid*/
            else if(counter1==0){
                mElementIndx1=i;
                counter1=1;
            }
            /*If the number is not the same as either candid one or 2 we decrease their counter*/
            else{
                counter1--;
                counter2--;
            }


        }
        /*Storing the result and retuirning*/
        candidates[0]=mElementIndx1;
        candidates[1]=mElementIndx2;
        return candidates;

    }

    /**
     * This method checks to see if the candidates are actually majority element
     * @param candidates
     * @param numbers
     * @param sizeN
     * @return result arrays
     */
    public static int[] isMajority (int [] candidates, int [] numbers, int sizeN){
        /*This is the required value*/
        int majorityElementOccurance=sizeN/3;
        /*counting the number of occcurances of each candidate using a for loop*/
        int candid1Count=0;
        int candid2Count=0;
        int [] results= {-1,-1};
        for(int i=0; i<sizeN;i++){
            if(numbers[i]==numbers[candidates[0]]) candid1Count++;
            if(numbers[i]==numbers[candidates[1]]) candid2Count++;
        }
        /*Checking to see if the count is more than N/3 otherwise the value stays at -1*/
        if(candid1Count>majorityElementOccurance) results[0]=numbers[candidates[0]];
        if(candid2Count>majorityElementOccurance) results[1]=numbers[candidates[1]];
        return results;
    }

}
