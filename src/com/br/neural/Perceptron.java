package com.br.neural;

import java.util.Random;

/**
 * 
 * @author edson
 *
 */
public class Perceptron {
	
	//Defines a hyperplane passing through the source
	private static double bias[];
	
	private static double deltabs1[];

	private static double [][] weights;

	private static double [][] deltaWeights;
	private static double net1[];
	private static double error1[][];
	private static double error2[][];


	private static double fnet1[];

	private static double [][] inputs;

	private static double [][] outputs;


	//Attribute that indicates the number of inputs
	private static int numInputs;

	//Attribute that indicates the number of outputs
	private static int numOutputs;

	//Attribute indicating the number of cycles
	private static int cycles;

	//Attribute that indicates the current time
	private static int cycleStart;

	//Attribute that indicates the number of trainings
	private static int numTraining;

	//Attribute that indicates the value of Alpha (learning rate)
	private static double alfa;

	//Attribute that indicates the value of Momentum
	private static double beta;
	
	//Attribute that indicates the seed value of the random number generator
	private static long seed;


	/**
	 * Returns the value of seed
	 * @return
	 */
	public static long getSeed(){
		return seed;
	}

	/**
	 * Assigns the value of  seed.
	 * @param value
	 */
	public static void setSeed(long value){
		seed = value;
	}
	
	/**
	 * Returns the value of beta (moment)
	 * @return
	 */
	public static double getBeta(){
		return beta;
	}

	/**
	 * Assigns the value of  beta.
	 * @param value
	 */
	public static void setBeta(double value){
		beta = value;
	}

	/**
	 * Returns the value of alfa
	 * @return
	 */
	public static double getAlfa(){
		return alfa;
	}

	/**
	 * Assigns the value of  alfa.
	 * @param value
	 */
	public static void setAlfa(double value){
		alfa = value;
	}

	/**
	 * Returns the value of training examples
	 * @return
	 */
	public static int getNumTraining(){
		return numTraining;
	}

	/**
	 * Assigns the values of training examples
	 * @param value
	 */
	public static void setNumTraining(int value){
		numTraining = value;
	}

	/**
	 * Returns the value of cycles
	 * @return
	 */
	public static int getCycles(){
		return cycles;
	}

	/**
	 * Assigns the values of cycles.
	 * @param value
	 */
	public static void setCycles(int value){
		cycles = value;
	}

	/**
	 *
	 * Returns the current cycle
	 * @return
	 */
	public static int getCycleStart(){
		return cycleStart;
	}

	/**
	 * Assigns the values of moment
	 * @param value
	 */
	public static void setCycleStart(int value){
		cycleStart = value;
	}

	/**
	 * 
	 * Returns the value of outputs
	 * @return
	 */
	public static int getNumOutputs(){
		return numOutputs;
	}

	/**
	 * Assigns the values of outputs
	 * @param value
	 */
	public static void setNumOutputs(int value){
		numOutputs = value;
		
		bias = new double[getNumOutputs()];
	    net1 = new double[getNumOutputs()];
		fnet1 = new double[getNumOutputs()];
		deltabs1 = new double [getNumOutputs()];
	}

	/**
	 * Returns the value of inputs.
	 * @return
	 */
	public static int getNumInputs(){
		return numInputs;
	}

	/**
	 * Assigns the values of inputs.
	 * @param value
	 */
	public static void setNumInputs(int value){
		numInputs = value;

	}

	/**
	* Assigns the value of the bias (threshold) to the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setBias(int index, double value){
		bias[index]=value;
	}

	/**
	 * 
	 * Returns the value of bias in the given index.
	* @param index: vector index.
	*/
	public static double getBias(int index){
		return bias[index];
	}

	/**
	* Assigns the value of net1 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setNet1(int index, double value){
		net1[index]=value;
	}

	/**
	* Returns the value of netin1 at the given index.
	* @param index: vector index.
	*/
	public static double getNet1(int index){
		return net1[index];
	}

	/**
	* Returns the value of fnet1 at the given index.
	* @param index: vector index.
	*/
	public static double getFnet1(int index){
		return fnet1[index];
	}

	/**
	* Returns the value of fnet1 at the given index.
	* @param index: vector index.
	*/
	public static void setFnet1(int index, double value){
		fnet1[index]=value;
	}


	/**
	* Assigns the value of deltabs1 to the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setDeltabs1(int index, double value){
		deltabs1[index]=value;
	}

	/**
	* Assigns the value of deltabs1 to the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static double getDeltabs1(int index){
		return deltabs1[index];
	}

	/**
	 * Returns the value of  Weights
	 * @return
	 */
	public static double getWeights(int row, int col){
		return weights[row][col];
	}

	/**
	 * Assigns the value of  Weights.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setWeights(int row, int col, double value){
		weights[row][col] = value;
	}

	/**
	 * Returns the value of DeltaWeights
	 * @return
	 */
	public static double getDeltaWeights(int row, int col){
		return deltaWeights[row][col];
	}

	/**
	 * Assigns the value of DeltaWeights
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setDeltaWeights(int row, int col, double value){
		deltaWeights[row][col] = value;
	}

	/**
	* Initializes the value of the Weights array.
	* @param row
	* @param col
	*/
	public static void initWeights(int row, int col){
		weights = new double[row][col];
	}



	/**
	 * Returns the value of Error1
	 * @return
	 */
	public static double getError1(int row, int col){
		return error1[row][col];
	}

	/**
	 * Assigns the value of Error1.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setError1(int row, int col, double value){
		error1[row][col] = value;
	}


	/**
	 * Returns the value of error2
	 * @return
	 */
	public static double getError2(int row, int col){
		return error2[row][col];
	}

	/**
	 * Assigns the value of error2.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setError2(int row, int col, double value){
		error2[row][col] = value;
	}


	/**
	* Initializes the value of the DeltaWeights array.
	* @param row
	* @param col
	*/
	public static void initDeltaWeights(int row, int col){
		deltaWeights = new double[row][col];
	}

	/**
	* Initializes the value of the Error1 array.
	* @param row
	* @param col
	*/
	public static void initError1(int row, int col){
		error1 = new double[row][col];
	}

	/**
	* Initializes the value of the array error2.
	* @param row
	* @param col
	*/
	public static void initError2(int row, int col){
		error2 = new double[row][col];
	}

	/**
	* Returns the value of the input matrix.
	* @param row
	* @param col
	*/
	public static double getinputs(int row, int col){
		return inputs[row][col];
	}

	/**
	* Returns the value of the output array.
	* @param row
	* @param col
	*/
	public static double getoutputs(int row, int col){
		return outputs[row][col];
	}

	/**
	* Initialization of weights.
	*
	*/
	public static void randomize(){

		//Create an Instance of Random
		Random random = new Random(getSeed());

		for (int j=0; j<getNumOutputs(); j++) {
			//setBias(j,-1+random.nextInt(8192)/8192);
			setBias(j,0.0);			
			setDeltabs1(j, 0.0d);
			
			for (int i=0; i<getNumInputs(); i++) {
				//setWeights(j, i, random.nextInt(8192)/8192-0.5d);
				setWeights(j, i, 0.0);				
				setDeltaWeights(j, i, 0.0d);
			}
		}
		
		
	}

	
	public static void Forward () {
		for(int kl=0; kl<getCycles(); kl++) {
			setCycleStart(getCycleStart()+ 1);
			for(int itr=0; itr<getNumTraining(); itr++) {

				double ea,eb;
				for (int j=0;j<getNumOutputs();j++) {
					setNet1(j, getBias(j));
					for(int i=0;i<getNumInputs();i++){
						setNet1(j,getNet1(j)+ (getWeights(j, i)* getinputs(itr,i)));
					}

					if (getNet1(j)>= 0.0)
					ea=1.0;
					else
						ea=0.0;
					
					setFnet1(j,(double) (ea));
				}



				//Readjustment of Weights				
				for(int j=0;j<getNumOutputs();j++) {
					setError2(itr,j, (getoutputs(itr,j) - getFnet1(j)));
					// output data printout
					System.out.println ("\r\n" + "Cycle:" + "" + getCycleStart () + "\r\n" + "Example:" + "" + (itr + 1) + "\r\n");

					System.out.println ("Desired output:" + "" + getoutputs (itr, j) + "\r\n" + "Calculated output:"+ "" + getFnet1 (j));
					System.out.println ("Error:" + "" + getError2 (itr, j));

				}

				for(int j=0;j<getNumOutputs();j++) {
					setDeltabs1(j,( getAlfa() * getError2(itr,j)));

					for(int ii=0;ii<getNumInputs();ii++) {
						setDeltaWeights(j,ii, (getAlfa() * getError2(itr,j))*(getinputs(itr,ii)));

					}
				}

				for(int j=0;j<getNumOutputs();j++) {
					setBias(j, getDeltabs1(j) + getBias(j));
					System.out.println("bias:"+" " + (j+1) +"      "+ getBias(j)+ "  ");

					for(int ii=0;ii<getNumInputs();ii++) {

						setWeights(j,ii, getWeights(j,ii)+(getDeltaWeights(j,ii)));
						
						System.out.println("Weight:" +" "+ (j+1)+" " + (ii+1) + "    " +getWeights(j,ii));

					}

				}

			}
		}
	}

	
	/**
	 * Main method*
	 *@param args
	*/
	public static void main (String [] args) {

	// -----------------------------------------
	setSeed (13);
	setCycles (3);
	setCycleStart (0);
	setNumInputs (9);
	setNumOutputs (1);
	setNumTraining (2);
	setAlfa (1.0);
	setBeta (0.0);

	// -----------------------------------------

	// Initialize the size of the arrays.
	initWeights (getNumOutputs (), getNumInputs ());
	initDeltaWeights (getNumOutputs (), getNumInputs ());


	initError2 (getNumTraining (), getNumOutputs ());

	initError1 (getNumTraining (), getNumOutputs ());

	// --------------------------------------------


	// Start the random weights.
	randomize ();

	// Initializes the values of the inputs matrix.
	double [] [] inputsInit = {{1,1,1,0,1,0,0,1,0},
	{1,0,1,1,1,1,1,0,1}};

	inputs = inputsInit;

	// Initializes the values of the output matrix (4x1).
	double [] [] outputsInit = {{1},
	{0}};


	outputs = outputsInit;

	Forward ();

	}

}
