Cryptography Assignment #1

Documentation
1.	Introduction to code
An RC4 state is a 256 bytes states with two 8-bit index pointers, i and j, denoted by (S, i, j). An important feature of RC4 is that the RC4 state is reversible. That is, 
if (S*, i*, j*) = PRGAn (S, i, j), 
it has (S, i, j) = IPRGAn (S*, i*, j*) 
where PRGAn denotes applying n rounds PRGA (same for IPRGAn) and IPRGA is the reverse algorithm of PRGA. This feature means that any former RC4 state can be recovered from a later RC4 state by applying certain rounds IPRGA.

The code here takes the number of PRGA and IPRGA rounds to be applied on an S array generated from a user provided key. It aims to verify that any previous state is retraceable from a later state is proper rounds of IPRGA are applied. The code does not perform any encryption or decryption of plaintext as it only focuses on the states.

2.	External Comment
The code uses two java classes.
a.	The Main_RC4_Code class: It contains the main user interactions and console displays.
b.	The RC4_Logic class: It contains the main logic for KSA, which is performed in the constructor. It also contains the PRGA and IPRGA implementations for specific rounds.

Bitwise AND operation
In the code it is required to perform (modulo 256) at certain points in the algorithm like,
	J = (j + S[i] + T[i]) mod 256
But, this results in a signed value for j in certain points during the loop, causing an ArrayOutOfBound exception on S[j].
Thus, replacing that with “& 0xFF” converts the result into an unsigned number. It is known that (mod 2i) can be calculated by (& 2i -1). Thus, we use “0xFF” which in integer refers to 255.
 
3.	How to run code
Using Eclipse
You should have an eclipse IDE with java development plugins installed on your PC.
	Open the Eclipse IDE and navigate to workspace
	Select File -> Import
	Expand General, select Existing projects into Workspace and then Next
	Click the Select archive file radio button and browse for the zip file containing the project.
	Click Finish and the project should appear in your workspace. Note: Eclipse will not import a project if you already have one with the same name. 
	Then you can simply select Run -> Run as Java Project.
	The result will be shown in the Console window.

4.	Screenshots of running code

The code starts and asks the user for the number of rounds of PRGA to be applied.
 

Enter any key. Here, we have used “pwd12”. And press Enter.
 
Now we have to input the number of rounds we want the PRGA and IPRGA loops to make. Here, we have entered 3.
 

Finally, we get 3 results,
a.	KSA generated State
b.	PRGA-n generated State
c.	IPRGA-n generated State
And it can be seen that KSA State = IPRGA-n State. Thus, we have obtained the initial state (KSA State) from a later state (i.e. result of PRGA-n) through IPRGA.

