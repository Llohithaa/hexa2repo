-- ----------  Case Study: Crime Analysis and Reporting System (C.A.R.S.)  ----------

create database CrimeReportingSystem;
use CrimeReportingSystem;

create table Victim(
VictimID int auto_increment primary key,
FirstName varchar(25) not null,
LastName varchar(25),
DateofBirth date,
Gender varchar(15),
Address Varchar(20),
ContactInformation varchar(10) check(length(ContactInformation)=10) not null
);

create table Suspect(
SuspectId int auto_increment primary key,
FirstName varchar(25) not null,
LastName varchar(25),
DateofBirth date,
Gender varchar(15),
Address Varchar(20),
ContactInformation varchar(10) check(length(ContactInformation)=10) not null
); 

create table Incident(
IncidentID int auto_increment Primary key,
IncidentType varchar(20) not null,
IncidentDate date not null,
Location varchar(25) not null,
Description varchar(200),
Status varchar(20),
VictimID int not null, constraint fk_VictimID
foreign key (VictimID) references Victim(VictimID),
SuspectId int not null, constraint fk_SuspectId
foreign key (SuspectId) references Suspect(SuspectId)
);

create table LawEnforcementAgency(
AgencyID int auto_increment primary key, 
AgencyName varchar(35) not null, 
Jurisdiction varchar(30),
ContactInformation varchar(10) check(length(ContactInformation)= 10) not null
); 

create table Officer(
OfficerID int auto_increment primary key,
FirstName varchar(20) not null, 
LastName varchar(10),
BadgeNumber varchar(5),
`Rank` varchar(10),
Address Varchar(20),
ContactInformation varchar(10) check(length(ContactInformation)=10) not null,
AgencyID int not null, constraint fk_AgencyID
foreign key (AgencyID) references LawEnforcementAgency(AgencyID)
);

create table Evidence(
EvidenceID int auto_increment primary key,
Description varchar(200) not null,
LocationFound varchar(25),
IncidentID int not null, constraint fk_IncidentID
foreign key (IncidentID) references Incident(IncidentID)
);

create table Report(
ReportID int auto_increment primary key,
IncidentID int not null, constraint fk_IncidentsID
foreign key (IncidentID) references Incident(IncidentID),
OfficerID int not null, constraint fk_OfficerID
foreign key (OfficerID) references Officer(OfficerID),
ReportDate date not null,
ReportDetails varchar(50),
Status varchar(20) not null
);

create table Complainant(
ComplainantID int auto_increment primary key,
ComplainantName varchar(20),
ContactInformation varchar(10) check(length(ContactInformation)=10) not null,
RelationShipWithVictim varchar(20)
);

create table Cases(
CaseID int auto_increment primary key,
VictimID int, constraint fk_victimID1
foreign key (victimID) references victim(victimID),
IncidentID int not null, constraint fk_IncidentsID1
foreign key (IncidentID) references Incident(IncidentID),
CaseDate date not null
);

Insert into Victim(VictimID, FirstName, LastName, DateofBirth, Gender, Address, ContactInformation)
values (1, 'Divya', 'J', '1998-08-29', 'Female', 'Koratur', 9876543210),
(2, 'Dharshini', 'G P', '2001-08-29', 'Female', 'Thirumulaivoyil', 7890123456),
(3, 'Sridevi', 'P', '2001-12-18', 'Female', 'Thirumulaivoyil', 6789012345),
(4, 'Lakshana', 'S', '2001-11-28', 'Female', 'Perambur', 8901234567),
(5, 'Sowmiya', 'N', '2002-06-03', 'Female', 'Porur', 5678901234),
(6, 'Sanjay', 'D', '2001-09-05', 'Male', 'Ambattur', 4567890123),
(7, 'Dharshan', 'S', '2001-07-21', 'Male', 'Chikmanglur', 4321098765),
(8, 'Mukunth', 'K', '2001-06-25', 'Male', 'Redhills', 8765432109),
(9, 'Gracelin', 'J', '2001-10-19', 'Female', 'Ambattur', 7654321098),
(10, 'Arthi', 'A', '2001-06-21', 'Female', 'Poonamallee', 4567890123);

Insert into Complainant(ComplainantID, ComplainantName, ContactInformation, RelationShipWithVictim)
values (131, 'Latha', 8475284738, 'mother'),
(132, 'Lohitha', 4878728394, 'sister'),
(133, 'jeevitha', 8347835798, 'cousin'),
(134, 'saravana', 9274873564, 'brother'),
(135, 'prabhakar', 6778483729, 'father');

Insert into Suspect(SuspectId, FirstName, LastName, DateofBirth, Gender, Address, ContactInformation)
values(21, 'Sathish', 'R J', '1992-02-15', 'Male', 'Koratur', 9988776655),
(22, 'Sudhakar', 'R', '1968-05-10', 'Male', 'Kr Puram', 8877665544),
(23, 'Thekkan', 'S', '2001-06-25', 'Male', 'Redhills', 7766554433),
(24, 'Surya', 'L', '1998-09-09', 'Male', 'Hosur', 6655443322),
(25, 'Selva Kumar', 'S', '2001-07-21', 'Male', 'Coimbatore', 5544332211),
(26, 'Ramesh', 'R', '1990-12-23', 'Male', 'Porur', 4433221100),
(27, 'Dinesh', 'J', '1991-02-01', 'Male', 'Chikmanglur', 3322110099),
(28, 'Suresh', 'M', '1992-04-01', 'Male', 'Redhills', 2211009988),
(29, 'kamesh', 'U', '1995-03-27', 'Male', 'Chrompet', 1122334455),
(30, 'Rajesh', 'K', '1989-05-15', 'Male', 'Ambattur', 1100998877);

Insert into LawEnforcementAgency(AgencyID, AgencyName, Jurisdiction, ContactInformation)
values (61, 'abc', 'Koratur', 9010203040),
(62, 'def', 'Kr Puram', 8919293949),
(63, 'ghi', 'Redhills', 7818283848),
(64, 'jkl', 'Hosur', 6717273747),
(65, 'mno', 'Coimbatore', 5616263646),
(66, 'pqr', 'Porur', 4515253545),
(67, 'stu', 'Chikmanglur', 3414243444),
(68, 'vwx', 'Redhills', 9232934566),
(69, 'yza', 'Chrompet', 7847785290),
(70,'bcd', 'Ambattur', 8377437465);

Insert into Incident(IncidentID, IncidentType, IncidentDate, Location, Description, Status, VictimID, SuspectId)
values (41, 'suicide', '2023-12-16', '13.1082° N, 80.1834° E', 'A tragic incident unfolded as an individual took their own life through intentional self-harm', 'Under Investigation', 1, 21),
(42, 'Cheating', '2024-01-20', '13.0170° N, 77.7044° E', 'An individual manipulated qualifications and provided false information during a job application process', 'Opened', 2, 22),
(43, 'Theft', '2022-08-31', '13.0473° N, 80.0945° E', 'An individual illicitly took possession of another persons belongings, engaging in theft', 'Closed', 3, 23),
(44, 'Missing Person', '2023-07-14', '12.7409° N, 77.8253° E', 'Individual reported missing, whereabouts unknown, family and friends concerned', 'Closed', 4, 24),
(45, 'Kidnapping', '2023-12-16', '11.0168° N, 76.9558° E', 'Individual forcibly abducted from home, released after ransom payment.', 'Opened', 5, 25),
(46, 'Theft', '2023-12-30', '13.0382° N, 80.1565° E', 'Laptop and belongings stolen from an unlocked car in a Tech Park', 'Under Investigation', 6, 26),
(47, 'Cybercrime', '2024-01-10', '13.3161° N, 75.7720° E', 'Hacker gained unauthorized access to a companys database, compromising customer information', 'Under Investigation', 7, 27),
(48, 'Cybercrime', '2023-11-30', '13.1865° N, 80.1999° E', 'Hacker gained unauthorized access to a phone data, and misused it', 'Closed', 8, 28),
(49, 'Harassment', '2024-01-21', '12.9516° N, 80.1462° E', 'Persistent and unwanted communication causing emotional distress', 'Opened', 9, 29),
(50, 'Cheating', '2023-06-10', '13.1186° N, 80.1574° E', 'The sudden dismissal of employee in secured job raises questions about the reasons behind the decision', 'Closed', 10, 30);

Insert into Officer(OfficerID, FirstName, LastName, BadgeNumber, `Rank`, Address, ContactInformation, AgencyID)
values (111, 'Lokesh', 'K', 'BNO1', 'SI', 'Koratur', 6574839201, 61),
(112, 'Ram', 'K', 'BNO2', 'ASI', '', 9808797686, 62),
(113, 'Vignesh', 'L', 'BNO3', 'HC', 'Koratur', 5213435657, 63),
(114, 'Nishwant', 'N', 'BNO4', 'SI', 'Kr Puram', 4357689801, 64),
(115, 'Badrinath', 'K', 'BNO5', 'ASI', 'Koratur', 6574839034, 65),
(116, 'Bhuvanesh', 'N', 'BNO6', 'SI', 'Koratur', 4321578954, 66),
(117, 'Vishwa', 'A', 'BNO7', 'HC', 'Koratur', 8765432655, 67),
(118, 'Siva', 'K', 'BNO8', 'ASI', 'Koratur', 3445277875, 68),
(119, 'Bhaskar', 'S', 'BNO9', 'SI', 'Koratur', 7294865623, 69),
(120, 'Christopher', 'S', 'BNO10', 'HC', 'Koratur', 9023563646, 70);

Insert into cases(CaseID, IncidentID, victimID, CaseDate)
values(201, 41, 1, '2023-12-17'),
(202, 44, 2, '2023-07-15'),
(203, 45, 3, '2023-12-16'),
(204, 49, 4, '2024-01-23'),
(205, 47, 5, '2024-01-14');


Insert into Evidence (EvidenceID, Description, LocationFound, IncidentID)
values(1, 'Medical examiner reports, and relevant documentation pertaining to the investigation', 'Korattur', 41),
(2, 'communication records and confessions related to the deceptive practices', 'Kr Puram', 42),
(3, 'CCTV footage showing the thieves targeting, as well as witness statements', 'Poonamallee', 43),
(4, 'Last known location data, witness statements, and any relevant personal belongings left behind', 'Hosur', 44),
(5, 'Surveillance footage, witness statements, and any communication logs related to the incident', 'Coimbatore', 45),
(6, 'CCTV footage showing the thieves targeting unlocked cars in the company parking lot', 'Porur', 46),
(7, 'Server logs, network activity records, and forensic analysis of the compromised database', 'Chikmanglur', 47),
(8, 'Server logs and network activity records of the compromised database', 'Redhills', 48),
(9, 'Communication records, witness statements, and any documentation of unwanted contact', 'Chrompet', 49),
(10, 'Employment records, termination letters, and any documentation outlining the reasons for the employee dismissal', 'Ambattur', 50);

Insert into Report(ReportID, IncidentID, OfficerID, ReportDate, ReportDetails, Status)
values (81, 41, 111, '2023-12-16', 'actions taken by law enforcement', 'draft'),
(82, 42, 112, '2024-01-20', 'evidence related to the cheating case', 'draft'),
(83, 43, 113, '2022-08-31', 'witness statements or evidence', 'Finalized'),
(84, 44, 114, '2023-07-14', 'steps taken in the search', 'Finalized'),
(85, 45, 115, '2023-12-16', 'efforts taken to locate the victim', 'draft'),
(86, 46, 116, '2023-12-30', 'witness statements or evidence', 'draft'),
(87, 47, 117, '2024-01-10', 'steps taken to mitigate the breach', 'draft'),
(88, 48, 118, '2023-11-30', 'steps taken to mitigate the breach', 'Finalized'),
(89, 49, 119, '2024-01-21', ' Account of the harassment incidents', 'draft'),
(90, 50, 120, '2023-06-10', 'relevant documentation', 'Finalized');

select * from victim where victimid=13;
select *  from suspect where suspectid=32;
select *  from incident where incidentid=53;
select * from LawEnforcementAgency;
select * from officer;
select * from evidence;
select * from cases;
select * from complainant;
select * from report;

drop database CrimeReportingSystem;