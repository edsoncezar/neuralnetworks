package com.br.neural;

import java.util.Random;

/**
 * 
 * @author edson
 *
 */
public class BackpropagationMLP {

	//Defines a hyperplane passing through the source
	private static double bias1[];
	private static double bias2[];

	private static double olddeltabs1[];
	private static double olddeltabs2[];
	private static double deltabs1[];
	private static double deltabs2[];

	private static double [][] weights1;
	private static double [][] weights2;

	private static double [][] olddeltaweights1;
	private static double [][] olddeltaweights2;

	private static double [][] deltaweights1;
	private static double [][] deltaweights2;

	private static double net1[];
	private static double net2[][];
	private static double netout[][];
	private static double error1[][];
	private static double error2[][];

	private static double sensation[];

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
	
	// Attribute that indicates the number of hidden layers.
	private static int numHidden;


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
	* Assigns the number of outputs.
	* @param value
	*/
	public static void setNumOutputs(int value){
		numOutputs = value;

		//inicializa os vetores para bias2 e prdlbs2
		bias2 = new double[getNumOutputs()];
		olddeltabs2 = new double[getNumOutputs()];
		deltabs2 = new double[getNumOutputs()];
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
	 * Returns the number of hidden neurons.
	 * @return
	 */
	public static int getNumHidden(){
		return numHidden;
	}

	/**
	 * Assigns the number of hidden neurons.
	 * @param value
	 */
	public static void setNumHidden(int value){
		numHidden = value;

		//Inicializa o vetor para bias1, netin1, sum1, prdlbs1, delbs1.
		bias1 = new double[getNumHidden()];
		net1 = new double[getNumHidden()];
		sensation = new double[getNumHidden()];
		fnet1 = new double[getNumHidden()];
		olddeltabs1 = new double [getNumHidden()];
		deltabs1 = new double [getNumHidden()];
	}

	/**
	* Assigns the value of the bias1 (threshold) to the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setBias1(int index, double value){
		bias1[index]=value;
	}

	/**
	 * 
	 * Returns the value of bias1 in the given index.
	* @param index: vector index.
	*/
	public static double getBias1(int index){
		return bias1[index];
	}

	/**
	 * 
	 * Returns the value of bias2 in the given index.
	* @param index: vector index.
	*/
	public static double getBias2(int index){
		return bias2[index];
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
	 * Assigns the value of sum1 to the given index.
	 * @param index: vector index.
	 * @param value: value to be assigned.
	 */
	public static void setSensation(int index, double value){
		sensation[index]=value;
	}

	/**
	 * Returns the value of sensation at the given index.
	 * @param index: vector index.
	 */
	public static double getSensation(int index){
		return sensation[index];
	}


	/**
	* Returns the value of fnet1 at the given index.
	* @param index: vector index.
	*/
	public static double getFnet1(int index){
		return fnet1[index];
	}

	/**
	* Assigns the value of fnet1 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setFnet1(int index, double value){
		fnet1[index]=value;
	}



	/**
	 * Returns the value of olddeltabs2 at the given index.
	 * @param index: vector index.
	 */
	public static double getOlddeltabs2(int index){
		return olddeltabs2[index];
	}

	/**
	* Assigns the value of fnet1 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setOlddeltabs1(int index, double value){
		olddeltabs1[index]=value;
	}

	/**
	* Assigns the value of fnet1 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setOlddeltabs2(int index, double value){
		olddeltabs2[index]=value;
	}

	/**
	 * Returns the value of olddeltabs1 at the given index.
	 * @param index: vector index.
	 */
	public static double getOlddeltabs1(int index){
		return olddeltabs1[index];
	}

	/**
	* Assigns the value of deltabs1 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setDeltabs1(int index, double value){
		deltabs1[index]=value;
	}

	/**
	 * Returns the value of deltabs1 at the given index.
	 * @param index: vector index.
	 */
	public static double getDeltabs1(int index){
		return deltabs1[index];
	}

	/**
	* Assigns the value of deltabs2 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setDeltabs2(int index, double value){
		deltabs2[index]=value;
	}

	/**
	 * Returns the value of deltabs2 at the given index.
	 * @param index: vector index.
	 */
	public static double getDeltabs2(int index){
		return deltabs2[index];
	}


	/**
	* Assigns the value of bias2 at the given index.
	* @param index: vector index.
	* @param value: value to be assigned.
	*/
	public static void setBias2(int index, double value){
		bias2[index]=value;
	}

	/**
	 * Returns the value of weights1 at the given index.
	 * @param index: vector index.
	 */
	public static double getWeights1(int row, int col){
		return weights1[row][col];
	}

	/**
	 * Assigns the value of weights1 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setWeights1(int row, int col, double value){
		weights1[row][col] = value;
	}

	/**
	 * Returns the value of weights2 at the given index.
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getWeights2(int row, int col){
		return weights2[row][col];
	}

	/**
	 * Assigns the value of weights2 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setWeights2(int row, int col, double value){
		weights2[row][col] = value;
	}

	/**
	 * Returns the value of olddeltaweights1 at the given index.
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getOlddeltaweights1(int row, int col){
		return olddeltaweights1[row][col];
	}

	/**
	 * Assigns the value of olddeltaweights2 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setOlddeltaweights2(int row, int col, double value){
		olddeltaweights2[row][col] = value;
	}

	/**
	 * Returns the value of olddeltaweights2 at the given index.
	 * @return
	 */
	public static double getOlddeltaweights2(int row, int col){
		return olddeltaweights2[row][col];
	}

	/**
	 * Returns the value of olddeltaweights1 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setOlddeltaweights1(int row, int col, double value){
		olddeltaweights1[row][col] = value;
	}

	/**
	 * Returns the value of deltaweights1 at the given index.
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getDeltaweights1(int row, int col){
		return deltaweights1[row][col];
	}

	/**
	 * Assigns the value of deltaweights1 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setDeltaweights1(int row, int col, double value){
		deltaweights1[row][col] = value;
	}

	/**
	 * Returns the value of deltaweights2 at the given index.
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getDeltaweights2(int row, int col){
		return deltaweights2[row][col];
	}

	/**
	 * Assigns the value of deltaweights2 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setDeltaweights2(int row, int col, double value){
		deltaweights2[row][col] = value;
	}

	/**
	* Initializes the value of the Weights array.
	* @param row
	* @param col
	*/
	public static void initWeights1(int row, int col){
		weights1 = new double[row][col];
	}


	/**
	 * Returns the value of Net2
	 * @return
	 */
	public static double getNet2(int row, int col){
		return net2[row][col];
	}

	/**
	 * Assigns the value of net2 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setNet2(int row, int col, double value){
		net2[row][col] = value;
	}

	/**
	 * Returns the value of Error1
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getError1(int row, int col){
		return error1[row][col];
	}

	/**
	 * Assigns the value of Error1 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setError1(int row, int col, double value){
		error1[row][col] = value;
	}


	/**
	 * Returns the value of Netout
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getNetout(int row, int col){
		return netout[row][col];
	}

	/**
	 * Assigns the value of Netout at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setNetout(int row, int col, double value){
		netout[row][col] = value;
	}

	/**
	 * Returns the value of error2
	 * @param row
	 * @param col
	 * @return
	 */
	public static double getError2(int row, int col){
		return error2[row][col];
	}

	/**
	 * Assigns the value of error2 at the given index.
	 * @param row
	 * @param col
	 * @param value
	 */
	public static void setErro2(int row, int col, double value){
		error2[row][col] = value;
	}

	/**
	 * Initializes the value of the weights2 array.
	 * @param row
	 * @param col
	 */
	public static void initWeights2(int row, int col){
		weights2 = new double[row][col];
	}

	/**
	 * Initializes the value of the olddeltaweights1 array.
	 * @param row
	 * @param col
	 */
	public static void initOlddeltaweights1(int row, int col){
		olddeltaweights1 = new double[row][col];
	}

	/**
	 * Initializes the value of the olddeltaweights2 array.
	 * @param row
	 * @param col
	 */
	public static void initOlddeltaweights2(int row, int col){
		olddeltaweights2 = new double[row][col];
	}

	/**
	 * Initializes the value of the deltaweights1 array.
	 * @param row
	 * @param col
	 */
	public static void initDeltaweights1(int row, int col){
		deltaweights1 = new double[row][col];
	}

	/**
	 * Initializes the value of the deltaweights2 array.
	 * @param row
	 * @param col
	 */
	public static void initDeltaweights2(int row, int col){
		deltaweights2 = new double[row][col];
	}

	/**
	 * Initializes the value of the net2 array.
	 * @param row
	 * @param col
	 */
	public static void initNet2(int row, int col){
		net2 = new double[row][col];
	}

	/**
	 * Initializes the value of the error1 array.
	 * @param row
	 * @param col
	 */
	public static void initError1(int row, int col){
		error1 = new double[row][col];
	}

	/**
	 * Initializes the value of the netout array.
	 * @param row
	 * @param col
	 */
	public static void initNetout(int row, int col){
		netout = new double[row][col];
	}

	/**
	 * Initializes the value of the error2 array.
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
	public static double getInputs(int row, int col){
		return inputs[row][col];
	}

	/**
	* Returns the value of the output array.
	* @param row
	* @param col
	*/
	public static double getOutputs(int row, int col){
		return outputs[row][col];
	}

	/**
	* Initialization of weights.
	*
	*/
	public static void randomize(){

		//Cria uma inst�ncia de Random
		Random random = new Random(getSeed());

		for (int j=0; j<getNumHidden(); j++) {
			setBias1(j,-1+random.nextInt(8192)/8192);
			setOlddeltabs1(j, 0.0d);
			setDeltabs1(j, 0.0d);
			
			for (int i=0; i<getNumInputs(); i++) {
				setWeights1(j, i, random.nextInt(8192)/8192-0.5d);
				setOlddeltaweights1(j, i, 0.0d);
				setDeltaweights1(j, i, 0.0d);
			}
		}
		
		for (int j=0; j<getNumOutputs(); j++) {
			setBias2(j,-0.1d + random.nextInt(8192)/8192);
			setOlddeltabs2(j, 0.0d);
			for (int i=0;i<getNumHidden(); i++) {
				setWeights2(j, i, 0.1d * random.nextInt(8192)/8192- 0.05);
				setOlddeltaweights2(j, i, 0.0d);
				setDeltaweights2(j, i, 0.0d);
			}
		}
	}

	

	public static void Forward () {
		for(int kl=0; kl<getCycles(); kl++) {
			setCycleStart(getCycleStart()+ 1);
			
			for(int itr=0; itr<getNumTraining(); itr++) {

				double ea,eb;
				for (int j=0;j<getNumHidden();j++) {
					setNet1(j, getBias1(j));
					for(int i=0;i<getNumInputs();i++){
						setNet1(j,getNet1(j)+ (getWeights1(j, i)* getInputs(itr,i)));
					}

					ea=(double)(Math.exp((double)((-1.0d)*(getNet1(j)))));

					setFnet1(j,(double) (1.0)/(1.0 + (ea)));
				}
	
				for(int j=0;j<getNumOutputs();j++)
				{
					setNet2(itr,j, getBias2(j));
					for(int i=0;i<getNumHidden();i++){
						setNet2(itr,j,getNet2(itr,j)+(getWeights2(j, i)*getFnet1(i)));
					}
					eb=(double)(Math.exp((double)((-1.0d)*(getNet2(itr,j)))));
					
					setNetout(itr,j, (double) (1.0/(1.0+eb)));
				}

				//Reajustando os pesos
				for(int j=0;j<getNumOutputs();j++) {
					setErro2(itr,j, (getOutputs(itr,j) - getNetout(itr,j)));
					//impress�o dos dados de sa�da
					System.out.println("Ciclo:"+ " "+ getCycleStart() + "  "+	"Exemplo:" +" "+ (itr+1));

					System.out.println("Sa�da desejada:"+" "  +  getOutputs(itr,j)+ "  "+ "Sa�da calculada:" 
					+" " +getNetout(itr,j));
					System.out.println("Erro:" +" "+ getError2(itr,j));
					
									
					setDeltabs2(j,( getAlfa() * getError2(itr,j))*getNetout(itr,j)*
					(1.0-getNetout(itr,j))+(getBeta() * getOlddeltabs2(j)));

					for(int i=0;i<getNumHidden();i++){
						setDeltaweights2(j, i,( getAlfa()*getError2(itr,j)*
								getNetout(itr,j)*(1.0-getNetout(itr,j))*getFnet1(i))+
								(getBeta()*getOlddeltaweights2(j, i)));
					}
				}

				for(int j=0;j<getNumHidden();j++) {
					setSensation(j, 0.0d);
					for(int i=0;i<getNumOutputs();i++) {
						setSensation(j, getSensation(j)+(getError2(itr,i)*getWeights2(i,j)));
					}

					setError1(itr,j, (getFnet1(j))*(1.0d-getFnet1(j))*getSensation(j));
					setDeltabs1(j,( getAlfa() * getError1(itr,j))+
							(getBeta() * getOlddeltabs1(j)));

					for(int ii=0;ii<getNumInputs();ii++) {
						setDeltaweights1(j,ii, (getAlfa() * getError1(itr,j))*(getInputs(itr,ii))+
								(getBeta() * getOlddeltaweights1(j,ii)));
					}
				}

				for(int j=0;j<getNumHidden();j++) {
					setBias1(j, getDeltabs1(j) + getBias1(j));
					setOlddeltabs1(j, getDeltabs1(j));
					System.out.println("bias:"+" " + (j+1) +"     "+ getBias1(j)+ "  ");

					for(int ii=0;ii<getNumInputs();ii++) {

						setWeights1(j,ii, getWeights1(j,ii)+(getDeltaweights1(j,ii)));
						System.out.println("Peso:" +" "+ (j+1)+" " + (ii+1) + "    " +getWeights1(j,ii));

						
						setOlddeltaweights1(j,ii, getDeltaweights1(j,ii));
					}
				}

				for(int j=0;j<getNumOutputs();j++) {
					setBias2(j, getDeltabs2(j) + getBias2(j));
					setOlddeltabs2(j, getDeltabs2(j));
					System.out.println("bias:"+" " + (j+1) +"     "+ getBias2(j)+ "  ");

					for(int i=0;i<getNumHidden();i++) {
						setWeights2(j,i, getWeights2(j, i)+ (getDeltaweights2(j,i)));
						setOlddeltaweights2(j, i, getDeltaweights2(j, i));
						System.out.println("Peso:" +" "+ (j+1)+" " + (i+1) + "    " +getWeights2(j,i));

						
					}
				}
			}
		}
	}

	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args){
		
		//-----------------------------------------
		setSeed (1315);
		setCycles (1000);
		setCycleStart (0);
		setNumInputs(1);
		setNumHidden(2);
		setNumOutputs(1);
		setNumTraining(7);
		setAlfa(0.1);
		setBeta(0.6);
		//-----------------------------------------
		
		// Initialize the size of the arrays.
		initWeights1(getNumHidden(),getNumInputs());
		initOlddeltaweights1(getNumHidden(),getNumInputs());
		initDeltaweights1(getNumHidden(),getNumInputs());
		
		initWeights2(getNumOutputs(),getNumHidden());
		initOlddeltaweights2(getNumOutputs(),getNumHidden());
		initDeltaweights2(getNumOutputs(),getNumHidden());

		initNet2(getNumTraining(), getNumOutputs());
		initNetout(getNumTraining(), getNumOutputs());
		initError2(getNumTraining(), getNumOutputs());
		
		initError1(getNumTraining(), getNumHidden());

		//--------------------------------------------
		
		
		// Start the random weights.
		randomize();
		
		// Initializes the values of the inputs matrix (1x7).
		double [][] inputsInit = {{1.50},
				{2.00},
				{2.50},
				{3.00},
				{3.50},
				{4.00},
				{4.5}};

		inputs = inputsInit;

		// Initializes the values of the output matrix (1x7).
		double [][] outputsInit = {{0.02},
				{0.08},
				{0.18},
				{0.50},
				{0.65},
				{0.88},
				{0.96}};


		outputs = outputsInit;
		
		Forward();

	}


}
