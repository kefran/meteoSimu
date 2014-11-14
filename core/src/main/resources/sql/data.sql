INSERT INTO Area SET Are_Id = 1, Are_Label = 'Mont Blanc';
INSERT INTO Area SET Are_Id = 2, Are_Label = 'Everest';

INSERT INTO Station SET Sta_Id = 1, Sta_Label = 'Station Sommet du Mont Blanc', Are_Id = 1, Sta_Valid = TRUE;
INSERT INTO Station SET Sta_Id = 2, Sta_Label = 'Station Flanc du Mont Blanc', Are_Id = 1, Sta_Valid = TRUE;
INSERT INTO Station SET Sta_Id = 3, Sta_Label = 'Station Everest', Are_Id = 2, Sta_Valid = TRUE;

INSERT INTO Sensor SET Sen_Id = 1, Sen_Label = 'Capteur ouest', Sta_Id = 1;
INSERT INTO Sensor SET Sen_Id = 2, Sen_Label = 'Capteur est', Sta_Id = 1;
INSERT INTO Sensor SET Sen_Id = 3, Sen_Label = 'Capteur ouest', Sta_Id = 2;
INSERT INTO Sensor SET Sen_Id = 4, Sen_Label = 'Capteur est', Sta_Id = 2;
INSERT INTO Sensor SET Sen_Id = 5, Sen_Label = 'Capteur ouest', Sta_Id = 3;
INSERT INTO Sensor SET Sen_Id = 6, Sen_Label = 'Capteur est', Sta_Id = 3;

INSERT INTO Temperature SET Tmp_Id = 1, Tmp_Value = 17.2, Tmp_Date = '2014-10-03 17:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 2, Tmp_Value = 16.0, Tmp_Date = '2014-10-03 18:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 3, Tmp_Value = 18.3, Tmp_Date = '2014-10-03 20:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 4, Tmp_Value = 19.6, Tmp_Date = '2014-10-03 22:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 5, Tmp_Value = 20.3, Tmp_Date = '2014-10-03 00:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 6, Tmp_Value = 14.6, Tmp_Date = '2014-10-03 03:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 7, Tmp_Value = 8.2, Tmp_Date = '2014-10-03 07:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 8, Tmp_Value = 3.0, Tmp_Date = '2014-10-03 09:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 9, Tmp_Value = 1.5, Tmp_Date = '2014-10-03 11:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 10, Tmp_Value = -3.7, Tmp_Date = '2014-10-03 14:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 11, Tmp_Value = -8.5, Tmp_Date = '2014-10-03 18:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 12, Tmp_Value = -12.0, Tmp_Date = '2014-10-03 19:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 13, Tmp_Value = -22.3, Tmp_Date = '2014-10-03 22:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 14, Tmp_Value = -17.9, Tmp_Date = '2014-10-03 01:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 15, Tmp_Value = -13.6, Tmp_Date = '2014-10-03 04:04:17', Sen_Id = 1;
INSERT INTO Temperature SET Tmp_Id = 16, Tmp_Value = 17.2, Tmp_Date = '2014-10-03 17:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 17, Tmp_Value = 16.0, Tmp_Date = '2014-10-03 18:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 18, Tmp_Value = 18.3, Tmp_Date = '2014-10-03 20:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 19, Tmp_Value = 19.6, Tmp_Date = '2014-10-03 22:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 20, Tmp_Value = 20.3, Tmp_Date = '2014-10-03 00:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 21, Tmp_Value = 14.6, Tmp_Date = '2014-10-03 03:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 22, Tmp_Value = 8.2, Tmp_Date = '2014-10-03 07:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 23, Tmp_Value = 3.0, Tmp_Date = '2014-10-03 09:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 24, Tmp_Value = 1.5, Tmp_Date = '2014-10-03 11:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 25, Tmp_Value = -3.7, Tmp_Date = '2014-10-03 14:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 26, Tmp_Value = -8.5, Tmp_Date = '2014-10-03 18:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 27, Tmp_Value = -12.0, Tmp_Date = '2014-10-03 19:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 28, Tmp_Value = -22.3, Tmp_Date = '2014-10-03 22:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 29, Tmp_Value = -17.9, Tmp_Date = '2014-10-03 01:04:17', Sen_Id = 2;
INSERT INTO Temperature SET Tmp_Id = 30, Tmp_Value = -13.6, Tmp_Date = '2014-10-03 04:04:17', Sen_Id = 2;

INSERT INTO Alert SET Alr_code = 'A001', Alr_Label = 'Alerte verglas à Paris', Alr_Description = 'Alerte s''enclenchant lorsque la température est négative à Paris';
INSERT INTO Alert SET Alr_code = 'A002', Alr_Label = 'Alerte neige à Tignes', Alr_Description = 'Alerte s''enclenchant lorsque la température est inférieure à -3 à Tignes';
INSERT INTO Alert SET Alr_code = 'A003', Alr_Label = 'Alerte chaleur à Marseille', Alr_Description = 'Alerte s''enclenchant lorsque la température est supérieure à 40 à Marseille';

INSERT INTO `Trigger` SET Trg_Id = 1, Trg_High = 0, Trg_Low = -9999, Trg_Edge = FALSE, Alr_code = 'A001', Sen_Id = 1;
INSERT INTO `Trigger` SET Trg_Id = 2, Trg_High = -3, Trg_Low = -9999, Trg_Edge = TRUE, Alr_code = 'A002', Sen_Id = 1;
INSERT INTO `Trigger` SET Trg_Id = 3, Trg_High = 9999, Trg_Low = 40, Trg_Edge = FALSE, Alr_code = 'A003', Sen_Id = 1;

INSERT INTO AlertHis SET Alh_Id = 1, Alh_Date = '2014-10-05', Alh_State = TRUE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 2, Alh_Date = '2014-10-05', Alh_State = FALSE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 3, Alh_Date = '2014-10-06', Alh_State = TRUE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 4, Alh_Date = '2014-10-06', Alh_State = FALSE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 5, Alh_Date = '2014-10-08', Alh_State = TRUE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 6, Alh_Date = '2014-10-08', Alh_State = FALSE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 7, Alh_Date = '2014-10-12', Alh_State = TRUE, Trg_Id = 1;
INSERT INTO AlertHis SET Alh_Id = 8, Alh_Date = '2014-10-12', Alh_State = FALSE, Trg_Id = 2;
INSERT INTO AlertHis SET Alh_Id = 9, Alh_Date = '2014-10-13', Alh_State = TRUE, Trg_Id = 2;
INSERT INTO AlertHis SET Alh_Id = 10, Alh_Date = '2014-10-13', Alh_State = FALSE, Trg_Id = 2;
INSERT INTO AlertHis SET Alh_Id = 11, Alh_Date = '2014-10-20', Alh_State = TRUE, Trg_Id = 2;
INSERT INTO AlertHis SET Alh_Id = 12, Alh_Date = '2014-10-20', Alh_State = FALSE, Trg_Id = 2;
INSERT INTO AlertHis SET Alh_Id = 13, Alh_Date = '2014-10-24', Alh_State = TRUE, Trg_Id = 2;
INSERT INTO AlertHis SET Alh_Id = 14, Alh_Date = '2014-10-24', Alh_State = FALSE, Trg_Id = 2;
