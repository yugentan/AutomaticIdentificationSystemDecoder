# Automatic Identification System Decoder

## Background
A novel re-implementation of my work done in one of my previous jobs. AIS, automatic identification system in short, is a tracking system that uses tranceivers (transmitter + receiver) on ships and is used by VTS (vessel traffic services). AIS information supplements marine radar, which serve as the primary method of collision avoidance for water transport.

## Description
This project only implements the **Receiver** aspect of the system. The primary job of the receiver is to decode in a valid message defined by a set of protocol established in the documentation  [**NMEA0183-2**](https://github.com/yugentan/AutomaticIdentificationSystemDecoder/blob/main/docs/NMEA0183-2.pdf) and [**R-REC-M.1371-5-201402 Standards**](https://github.com/yugentan/AutomaticIdentificationSystemDecoder/blob/main/docs/R-REC-M.1371-5-201402-I!!PDF-E_1.pdf).

## Usage
**Installation**
Clone the repository using Git:## Usage
**Installation** 

Clone the repository using Git:
```bash
git clone https://github.com/yugentan/AutomaticIdentificationSystemDecoder.git
```
Navigate to dist and running the jar file
```bash
cd AutomaticIdentificationSystemDecoder/dist
java -jar AISDecoder.jar
```
Alternatively, the project can be build from the src directory. This project is initialized on maven. Just make sure maven is installed.

## Example
During launch, application will be prompted with a user menu as defined below<br>

![image](https://github.com/yugentan/AutomaticIdentificationSystemDecoder/assets/84921573/17a597d0-45bf-4104-8ee2-8e5685c4f757)<br>

Entering 1 will prompt `Enter encoded message`
The following are some examples of valid encoded messages the AIS decoder should be able to decode.
  - !AIVDM,1,1,,A,13u?etPv2;0n:dDPwUM1U1Cb069D,0*24
  - !AIVDM,1,1,4,B,6>jR0600V:C0>da4P106P00,2*02
  - $GPHDT,274.07,T*03
  - $GPBWC,220516,5130.02,N,00046.34,W,213.8,T,218.0,M,0004.6,N,EGLM,A*4C
  - $GNGNS,122310.2,3722.425671,N,12258.856215,W,DD,14,0.9,1005.543,6.5,,*74
  - !AIVDM,1,1,1,B,8>h8nkP0Glr=<hFI0D6??wvlFR06EuOwgwl?wnSwe7wvlOw?sAwwnSGmwvh0,0*17
<br>
The following is an output from the decoder given the first message `!AIVDM,1,1,,A,13u?etPv2;0n:dDPwUM1U1Cb069D,0*24`
<br>
![image](https://github.com/yugentan/AutomaticIdentificationSystemDecoder/assets/84921573/49023aaf-0a0c-4835-86e6-9e2eb7f89cbb)
<br>
Enter messages that are valid and follows the documentation protocols else an invalid message will be prompted
