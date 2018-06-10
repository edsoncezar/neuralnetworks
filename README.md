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



