import java.util.Arrays;
import java.util.Random;

public class Algorithm {
	
	
	double[] dataset= {15,2,3,4,7,8,9,10,13,14,15,16};
	int[] group= new int[dataset.length];
	int k = 3;
	double []cj= new double[k];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test= {1,2,3,4,7,8,9,10,13,14,15,16};
		System.out.println(test.length);
		

		
		Algorithm a= new Algorithm();
		a.findCentroid();
		System.out.println(Arrays.toString(a.kMeans(a.cj)));
	
	}
	
	public int[] kMeans(double[] centroids){
		//den centroids zuordnen
		for(int i=0; i<dataset.length; i++){
			double min=maxValue(dataset)+1;
			int c=0;
			for(int j=0;j<k;j++){
				
				if(min>Math.abs(dataset[i]-cj[j])){
					min=Math.abs(dataset[i]-cj[j]);
					c=j;
				}	
			}
			group[i]=c;
		}
		double[] cj2=cj.clone();
		
		findAverage();
		if(!Arrays.equals(cj, cj2)){
			return kMeans(cj);
		}
		else{
			return group;
		}
	}
	
	public void findAverage(){
	
		for(int j=0;j<k;j++){
			double sum=0;
			int counter=0;
			for(int i=0;i<dataset.length;i++){
				if(group[i]==j){
					sum=sum+dataset[i];
					counter++;
				}
			}
			if(counter==0){
				Random rand=new Random(dataset.length);
				cj[j]=rand.nextDouble()*maxValue(dataset);
			}
			else{
				cj[j]=sum/counter; 
			}
		}

	}
	
	public void findCentroid(){
		Random r= new Random(dataset.length);
		//die ersten 3 cj finden (random)
		for(int i =0;i<k;i++){
			cj[i]=r.nextDouble()*maxValue(dataset);
		}
	}
	public double maxValue(double[] arr){
		double max=0;
		for(int i=0; i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
	
}
