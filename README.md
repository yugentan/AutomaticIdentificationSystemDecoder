# Automatic Identification System Decoder

## Background
A novel re-implementation of my work done in one of my previous jobs. AIS, automatic identification system in short, is a tracking system that uses tranceivers (transmitter + receiver) on ships and is used by VTS (vessel traffic services). AIS information supplements marine radar, which serve as the primary method of collision avoidance for water transport.

## Description
This project only implements the **Receiver** aspect of the system. The primary job of the receiver is to decode in a valid message defined by a set of protocol established in the documentation  [**NMEA0183-2**](https://github.com/yugentan/AutomaticIdentificationSystemDecoder/blob/main/docs/NMEA0183-2.pdf) and [**R-REC-M.1371-5-201402 Standards**](https://github.com/yugentan/AutomaticIdentificationSystemDecoder/blob/main/docs/R-REC-M.1371-5-201402-I!!PDF-E_1.pdf). The current implementation only support `Message 1`, `Message 2`, `Message 3`.
