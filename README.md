# neuralnetworks

In a simple way Artificial Neural Networks are computer models inspired by the

nervous system of living beings.



My goal is just explain Artificial Neural Networks in a simple way, first we need to start with a little of history:



Artificial Neuron Model by McCulloch & Pitts (1943)

 

Hebb Learning Rule (1949)



The Perceptron model of Rosenblatt (1958)



Discovery of the Perceptron limitation by Minsky and Papert (1969)



Hopfield Energy Approach (1982)



Backpropagation Learning Algorithm for Perceptron Networks Multiple Layers per Rumelhart (1986)



You can find the history in details in these sources:



History: The 1940's to the 1970's



History: The 1980's to the present



The second point is how works a Biological Neuron, a neuron, also known as a neurone (British spelling) and nerve cell, is an electrically excitable cell that receives, processes, and transmits information through electrical and chemical signals. These signals between neurons occur via specialized connections called synapses. Neurons can connect to each other to form neural networks. Neurons are the primary components of the central nervous system, which includes the brain and spinal cord, and of the peripheral nervous system, which comprises the autonomic nervous system and the somatic nervous system.



They are divided into:



Cell body or Soma - Produces potential of activation that will indicate whether the neuron can trigger a electric impulse along the axon, it contains the nucleus, which in turn contains the genetic material in the form of chromosomes.



Dendrites - Responsible for the capture, of stimuli from various neurons.



Axon - Made up of a single extension, they have function to drive electrical impulses to others connecting neurons to the dendrites.



Synapses - Which are configured as the connections that transfer of electrical impulses from the axon from one neuron to the dendrites of others.









The Artificial Neuron is separated in this way:



The input signals represented by the set {𝒙𝟏, 𝒙𝟐, ..., 𝒙𝒏}, are equivalent to the impulses dendrites.

Synapses are represented by adjusted synaptic weights in {𝒘𝟏, 𝒘𝟐, ..., 𝒘𝒏}.

The activation potential 𝒖 determined by sum function, is equivalent to the cellular body.

The output propagated by the axon is represented by 𝒚.







I will start with the most simple model of Artificial Neural Networks, In machine learning, the perceptron is an algorithm for supervised learning of binary classifiers (functions that can decide whether an input, represented by a vector of numbers, belongs to some specific class or not).[1] It is a type of linear classifier, i.e. a classification algorithm that makes its predictions based on a linear predictor function combining a set of weights with the feature vector.



One of the key elements of a neural network is its ability to learn. A neural network is not just a complex system, but a complex adaptive system, meaning it can change its internal structure based on the information flowing through it. Typically, this is achieved through the adjusting of weights. In the diagram above, each line represents a connection between two neurons and indicates the pathway for the flow of information. Each connection has a weight, a number that controls the signal between the two neurons. If the network generates a “good” output (which we’ll define later), there is no need to adjust the weights. However, if the network generates a “poor” output—an error, so to speak—then the system adapts, altering the weights in order to improve subsequent results.

There are several strategies for learning:


Supervised Learning —Essentially, a strategy that involves a teacher that is smarter than the network itself. For example, let’s take the facial recognition example. The teacher shows the network a bunch of faces, and the teacher already knows the name associated with each face. The network makes its guesses, then the teacher provides the network with the answers. The network can then compare its answers to the known “correct” ones and make adjustments according to its errors. Our first neural network in the next section will follow this model.


Unsupervised Learning —Required when there isn’t an example data set with known answers. Imagine searching for a hidden pattern in a data set. An application of this is clustering, i.e. dividing a set of elements into groups according to some unknown pattern.


Reinforcement Learning —A strategy built on observation. Think of a little mouse running through a maze. If it turns left, it gets a piece of cheese; if it turns right, it receives a little shock. (Don’t worry, this is just a pretend mouse.) Presumably, the mouse will learn over time to turn left. Its neural network makes a decision with an outcome (turn left or right) and observes its environment (yum or ouch). If the observation is negative, the network can adjust its weights in order to make a different decision the next time. Reinforcement learning is common in robotics. At time t, the robot performs a task and observes the results.

This simple perceptron algorithm has a simple goal to represent a load balance, example: 


Input Input Output

X1    X2    D (desired)

off   off   Not OK

off   on    Not OK

on    Off   Not OK

on    on    OK



Input Input Output

X1    X2    D (desired)

0     0     Not OK (0)

0     1     Not OK (0)

1     0     Not OK (0)

1     1     OK (1)


This is just a start, I will explain more about in the future:

http://edsonmcz.blogspot.com/2018/06/simple-explanation-about-artificial.html


_________________________________________________________________________________________________

Just continuing with my explanation about Artificial Neural Networks in a simple way.



The Adaline (Adaptive Linear Neuron or later Adaptive Linear Element) network, proposed by Widrow and Hoff in 1960, has the same structure as the Perceptron, differentiating only in the algorithm of training.


She is an adaptive network, with the Inclusion of a pioneering algorithm for the training of

multi-layered networks, the training algorithm of the Delta rule, the Delta rule algorithm is based on the method of least squares, she has a smoother learning method.



Their goal is Perform local iterations to get the function and thus set the values of the weights when the minimum was found.



Through an arbitrary point (vector of weights started randomly), the algorithm runs, at each iteration, the surface of the error function towards the point of Minimum.

Adaline is a single layer neural network with multiple nodes where each node accepts multiple inputs and generates one output. Given the following variables:as

x is the input vector
w is the weight vector
n is the number of inputs
\theta  some constant
y is the output of the model
then we find that the output is y=\sum _{{j=1}}^{{n}}x_{j}w_{j}+\theta . If we further assume that

{\displaystyle x_{0}=1}
{\displaystyle w_{0}=\theta }
then the output further reduces to: {\displaystyle y=\sum _{j=0}^{n}x_{j}w_{j}}

Learning algorithm

Let us assume:

\eta  is the learning rate (some positive constant)
y is the output of the model
o is the target (desired) output
then the weights are updated as follows w\leftarrow w+\eta (o-y)x. The ADALINE converges to the least squares error which is E=(o-y)^{2}.[6] This update rule is in fact the stochastic gradient descent update for linear regression.[7]


http://edsonmcz.blogspot.com/2018/06/adaline-adaptive-linear-neuron.html

______________________________________________________________________________________________________

Single Layer Perceptron – This is the simplest feedforward neural network and does not contain any hidden layer. 


Minsky and Papert mathematically analyzed Perceptron and demonstrated that single-layer networks are not capable of solving problems that are not linearly separable. As they did not believe in the possibility of constructing a training method for networks with more than one layer, they concluded that neural networks would always be susceptible to this limitation.



The multilayer perceptron (MLP) is a neural network similar to perceptron, but with more than one layer of neurons in direct power. Such a network is composed of layers of neurons connected to each other by synapses with weights. Learning in this type of network is usually done through the back-propagation error algorithm, but there are other algorithms for this purpose, such as Rprop.


http://edsonmcz.blogspot.com/2018/06/multi-layer-perceptrons-mlp-and.html






However, the development of the backpropagation training algorithm has shown that it is possible to efficiently train networks with intermediate layers, resulting in the most used artificial neural networks model currently, Perceptron Multi-Layer (MLP) networks, trained with the backpropagation algorithm.



The backpropagation algorithm was originally introduced in the 1970s, but its importance wasn't fully appreciated until a famous 1986 paper byDavid Rumelhart, Geoffrey Hinton, and Ronald Williams. That paper describes several neural networks where backpropagation works far faster than earlier approaches to learning, making it possible to use neural nets to solve problems which had previously been insoluble. Today, the backpropagation algorithm is the workhorse of learning in neural networks.

Backpropagation is a method used in artificial neural networks to calculate a gradient that is needed in the calculation of the weights to be used in the network.[1] It is commonly used to train deep neural networks,[2] a term referring to neural networks with more than one hidden layer.[3]

Backpropagation is a special case of an older and more general technique called automatic differentiation. In the context of learning, backpropagation is commonly used by the gradient descent optimization algorithm to adjust the weight of neurons by calculating the gradient of the loss function. This technique is also sometimes called backward propagation of errors, because the error is calculated at the output and distributed back through the network layers.

The backpropagation algorithm has been repeatedly rediscovered and is equivalent to automatic differentiation in reverse accumulation mode. Backpropagation requires the derivative of the loss function with respect to the network output to be known, which typically (but not necessarily) means that a desired target value is known. For this reason it is considered to be a supervised learning method, although it is used in some unsupervised networks such as autoencoders. Backpropagation is also a generalization of the delta rule to multi-layered feedforward networks, made possible by using the chain rule to iteratively compute gradients for each layer. It is closely related to the Gauss–Newton algorithm, and is part of continuing research in neural backpropagation. Backpropagation can be used with any gradient-based optimizer, such as L-BFGS or truncated Newton.



