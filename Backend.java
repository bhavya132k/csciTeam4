import java.util.Arrays;

public class Backend extends javax.swing.JFrame{

    // General Purpose Registers (16 Long)
    public static char[][] GPR = new char[4][16];
    
    // Index Registers (16 Long)
    public static char[][] XR = new char[4][16];

    // RAM (double array, 2048 by 16)
    public static char[][] RAM = new char[2048][16];

    // PC - 12 bits
    public static char[] PC = new char[12];

    // CC - 4 bits
    public static char[] CC = new char[4];

    // IR - 12 bits
    public static char[] IR = new char[16];

    // MAR - 12 bits
    // Memory Address Register: holds the address of the word to be fetched from memory
    public static char[] MAR = new char[12];

    // MBR - 16 bits
    // Memory Buffer Register: holds the word just fetched from or the word to be /last stored into memory
    public static char[] MBR = new char[16];

    // MFR - 12 bits
    public static char[] MFR = new char[4];

    public static String showGPR0 = "";
    public static String showGPR1 = "";
    public static String showGPR2 = "";
    public static String showGPR3 = "";
    public static String showXR0 = "";
    public static String showXR1 = "";
    public static String showXR2 = "";
    public static String showPC = "";
    public static String showCC = "";
    public static String showMAR = "";
    public static String showMBR = "";
    public static String showIR = "";
    public static String showMFR = "";
    private static String Rx;
    private static String Ry;
    private static String Immed;
    private static String input;

    public static void main(String[] args){
        init();
    }

    public static void load(){
        // Takes the value at the address in MAR and stores it in MBR
        System.out.println("~~~Running load~~~");
        String stringMAR = "";
        for (int i = 0; i < MAR.length; i++){
            stringMAR += MAR[i];
        }
        int intMAR = Integer.parseInt(stringMAR,2);
        System.out.println("~Pre Load~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();

        for (int i = 0; i < MBR.length; i++){
            MBR[i] = RAM[intMAR][i];
        }
        System.out.println("~Post Load~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();
    }

    public static void store(){
        // Takes the value in MBR and stores it at the address in MAR
        System.out.println("~~~Running store~~~");
        String stringMAR = "";
        for (int i = 0; i < MAR.length; i++){
            stringMAR += MAR[i];
        }
        int intMAR = Integer.parseInt(stringMAR,2);
        System.out.println("~Pre Store~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();
        System.out.println("~Post Store~");
        for (int i = 0; i < MBR.length; i++){
            RAM[intMAR][i] = MBR[i];
        }

        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();

    }

    public static void storePlus(){
        // Takes the value in MBR and stores it at the address in MAR then increments MAR
        System.out.println("~~~Running storePlus~~~");
        String stringMAR = "";
        for (int i = 0; i < MAR.length; i++){
            stringMAR += MAR[i];
        }
        int intMAR = Integer.parseInt(stringMAR,2);
        System.out.println("~Pre Store~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();
        
        for (int i = 0; i < MBR.length; i++){
            RAM[intMAR][i] = MBR[i];
        }
        intMAR ++;
        String intMARincremented = Integer.toBinaryString(intMAR);
        String stringMARincremented = "";
        for (int i = 12; i > intMARincremented.length(); i--){
            stringMARincremented += "0";
        }
        stringMARincremented += intMARincremented;
        for (int j = 0; j < MAR.length; j++){
            MAR[j] = stringMARincremented.charAt(j);
        }
        System.out.println("~Post Store~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR-1][i]);
        }
        System.out.println();

    }

    public static void init(){
        System.out.println("~~~Running init~~~");

        // INITIAL PROGRAM LOAD

        // General Purpose Registers (16 Long)
        for (int i = 0; i < GPR.length; i++){
            for (int j = 0; j < GPR[i].length; j++){
                GPR[i][j] = ('0');
            }
        }

        // Index Registers (16 Long)
        for (int i = 0; i < XR.length; i++){
            for (int j = 0; j < XR[i].length; j++){
                XR[i][j] = ('0');
            }
        }

        // RAM (double array, 2048 by 16)
        for (int i = 0; i < RAM.length; i++){
            for (int j = 0; j < RAM[i].length; j++){
                RAM[i][j] = ('0');
            }
        }
    
        // PC - 12 bits
        for (int i = 0; i < PC.length; i++){
            PC[i] = ('0');
        }

        PC[0] = ('0');
        PC[1] = ('0');
        PC[2] = ('0');
        PC[3] = ('0');
        PC[4] = ('0');
        PC[5] = ('0');
        PC[6] = ('0');
        PC[7] = ('0');
        PC[8] = ('0');
        PC[9] = ('1');
        PC[10] = ('1');
        PC[11] = ('0');
    
        // CC - 4 bits
        for (int i = 0; i < CC.length; i++){
            CC[i] = ('0');
        }
    
        // IR - 12 bits
        for (int i = 0; i < IR.length; i++){
            IR[i] = ('0');
        }
        // MFR - 4 bits
        for (int i = 0; i < MFR.length; i++){
            MFR[i] = ('0');
        }
        // MAR - 12 bits
        // Memory Address Register: holds the address of the word to be fetched from memory

        for (int i = 0; i < MAR.length; i++){
            MAR[i] = ('0');
        }
    
        // MBR - 16 bits
        // Memory Buffer Register: holds the word just fetched from or the word to be /last stored into memory    
        
        for (int i = 0; i < MBR.length; i++){
            MBR[i] = ('0');
        }
        
        // MANUALLY LOAD 1111111111111111 INTO GPR0 USING GUI
        // MANUALLY LOAD 0000000000000001 INTO XR1 USING GUI
        // MANUALLY LOAD 0000000000000010 INTO XR2 USING GUI
        // MANUALLY LOAD 0000000000010000 INTO XR3 USING GUI

        //STR GPR 0 XR 0 I 0 Address 10001
        RAM[6] = "0000100000010001".toCharArray();
        //STR GPR 0 XR 0 I 0 Address 10010
        RAM[7] = "0000100000010010".toCharArray();
        //LDA GPR 0 XR 2 I 0 Address 01111 (Will become 10001)
        RAM[8] = "0000110010001111".toCharArray();
        //LDA GPR 0 XR 2 I 0 Address 10000 (Will become 10010)
        RAM[9] = "0000110010010000".toCharArray();
        //LDR GPR 0 XR 1 I 0 Address 10000 (Will become 10001)
        RAM[10] = "0000010001010000".toCharArray();
        //LDR GPR 0 XR 1 I 0 Address 10001 (Will become 10010)
        RAM[11] = "0000010001010001".toCharArray();
        //STX GPR 1 XR 3 I 1 Address 00000 (Will become 10000)
        RAM[12] = "1010100111100000".toCharArray();
        //LDX GPR 1 XR 1 I 1 Address 01111 (Will become 10000)
        RAM[13] = "1010010101101111".toCharArray();
        //Value to test Indirect
        RAM[16] = "0000000000011111".toCharArray();
    }

    public static void PCincrement(){
        
        System.out.println("~Status Pre MAR Load~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        
        for (int j = 0; j < PC.length; j++){
            MAR[j] = PC[j];
        }
        System.out.println("~Status Post MAR Load~");
        System.out.print("MAR: ");
        for (int i = 0; i < 12; i++){
            System.out.print(MAR[i]);
        }
        System.out.println();
        
        String stringMAR = "";
        for (int i = 0; i < MAR.length; i++){
            stringMAR += MAR[i];
        }
        int intMAR = Integer.parseInt(stringMAR,2);
        System.out.println("~Status Pre MBR Load~");
        
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();

        for (int i = 0; i < MBR.length; i++){
            MBR[i] = RAM[intMAR][i];
        }
        System.out.println("~Status Post MBR Load~");
        System.out.print("MBR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(MBR[i]);
        }
        System.out.println();
        System.out.print("RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[intMAR][i]);
        }
        System.out.println();
        
        String incrementer = "";
        for (int i = 0; i < PC.length; i++){
            incrementer += PC[i];
        }
        // System.out.println("Incrementer: " + incrementer);
        int incrementing = Integer.parseInt(incrementer,2);
        incrementing++;
        // System.out.println("Incrementing: " + incrementing);
        String incremented = Integer.toBinaryString(incrementing);
        // System.out.println("Incremented: " + incremented);
        String incrementedPlus = "";
        for (int i = 12; i > incremented.length(); i--){
            incrementedPlus += "0";
        }
        // System.out.println("IncrementedPlus1: " + incrementedPlus);
        incrementedPlus += incremented;
        // System.out.println("IncrementedPlus2: " + incrementedPlus);

        for (int j = 0; j < PC.length; j++){
            PC[j] = incrementedPlus.charAt(j);
        }
    }


    public static void HALT() {
        //Halt
    }
    public static String IX(String input) {
        String IX = "";
        for (int i = 8; i < 10; i++){
            IX += input.charAt(i);
        }
        System.out.println("IX: " + IX);
        return IX;
    }

    public static String R(String input) {
        String R = "";
        for (int i = 6; i < 8; i++){
            R += input.charAt(i);
        }
        System.out.println("R: " + R);
        return R;
    }

    public static String I(String input) {
        String I = "";
        for (int i = 10; i < 11; i++){
            I += input.charAt(i);
        }
        System.out.println("I: " + I);
        return I;
    }

    public static String Address(String input) {
        String Address = "";
        for (int i = 11; i < 16; i++){
            Address += input.charAt(i);
        }
        System.out.println("Address: " + Address);
        return Address;
    }

    public static void LDR(String R, String IX, String I, String Address) {
        
        int indexR = Integer.parseInt(R,2);
        int indexEA = Integer.parseInt(EA(IX, I, Address),2);

        //This would be read as: Load register 3 with the contents of the memory location 31.
        System.out.println("~~~Running LDR~~~");
        System.out.println("~Status Pre GPR Load~");
        System.out.print("LDR - GPR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(GPR[indexR][i]);
        }
        System.out.println();
        System.out.print("LDR - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
        for (int i = 0; i < GPR[indexR].length; i++){
            GPR[indexR][i] = RAM[indexEA][i];
        }

        System.out.println("~Status Post GPR Load~");
        System.out.print("LDR - GPR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(GPR[indexR][i]);
        }
        System.out.println();
        System.out.print("LDR - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
    }

    public static void STR(String R, String IX, String I, String Address) {
        // System.out.println("R: " + R);
        int indexR = Integer.parseInt(R,2);
        System.out.println("EA: " + EA(IX, I, Address));
        int indexEA = Integer.parseInt(EA(IX, I, Address),2);

        //This would be read as: Load register 3 with the contents of the memory location 31.
        System.out.println("~~~Running STR~~~");
        System.out.println("~Status Pre RAM Load~");
        System.out.print("STR - GPR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(GPR[indexR][i]);
        }
        System.out.println();
        System.out.print("STR - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
        for (int i = 0; i < 16; i++){
            RAM[indexEA][i] = GPR[indexR][i];
        }
        System.out.println("~Status Post RAM Load~");
        System.out.print("STR - GPR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(GPR[indexR][i]);
        }
        System.out.println();
        System.out.print("STR - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
    }

    public static void LDA(String R, String IX, String I, String Address) {
        System.out.println("~~~Running LDA~~~");
        int indexR = Integer.parseInt(R,2);
        String EA = EA(IX, I, Address);
        
        //This would be read as: Load register 3 with the memory location 31.

        System.out.println("~Status Pre GPR Load~");
        System.out.print("LDA - GPR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(GPR[indexR][i]);
        }
        System.out.println();
        System.out.print("LDA - EA: ");
        System.out.println(EA);        
        
        for (int i = 0; i < (GPR[indexR].length - EA.length()); i++){
            GPR[indexR][i] = '0';
        }
        
        for (int i = (GPR[indexR].length - EA.length()); i < GPR[indexR].length; i++){
            GPR[indexR][i] = EA.charAt(i - (GPR[indexR].length - EA.length()));
        }

        System.out.println("~Status Post GPR Load~");
        System.out.print("LDA - GPR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(GPR[indexR][i]);
        }
        System.out.println();
        System.out.print("LDA - EA: ");
        System.out.println(EA);
    }

    public static void LDX(String R, String IX, String I, String Address) {
        int indexIX = Integer.parseInt(IX,2);
        int indexEA = Integer.parseInt(EA(IX, I, Address),2);
        System.out.println("~~~Running LDX~~~");
        // Load Index Register from Memory, x = 1..3
        // Xx <- c(EA)
        // System.out.println("indexIX: " + indexIX);
        // System.out.println("indexEA: " + indexEA);
        System.out.println("~Status Pre XR Load~");
        System.out.print("LDX - XR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(XR[indexIX][i]);
        }
        System.out.println();
        System.out.print("LDX - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();

        for (int i = 0; i < 16; i++){
            XR[indexIX][i] = RAM[indexEA][i];
        }

        System.out.println("~Status Post XR Load~");
        System.out.print("LDX - XR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(XR[indexIX][i]);
        }
        System.out.println();
        System.out.print("LDX - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
    }

    public static void STX(String R, String IX, String I, String Address) {
        int indexIX = Integer.parseInt(IX,2);
        int indexEA = Integer.parseInt(EA(IX, I, Address),2);
        System.out.println("~~~Running STX~~~");
        // Store Index Register to Memory. X = 1..3
        // Memory(EA) <- c(Xx)
        System.out.println("~Status Pre RAM Load~");
        System.out.print("LDX - XR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(XR[indexIX][i]);
        }
        System.out.println();
        System.out.print("LDX - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
        
        for (int i = 0; i < 16; i++){
            RAM[indexEA][i] = XR[indexIX][i];
        }

        System.out.println("~Status Post RAM Load~");
        System.out.print("LDX - XR: ");
        for (int i = 0; i < 16; i++){
            System.out.print(XR[indexIX][i]);
        }
        System.out.println();
        System.out.print("LDX - RAM: ");
        for (int i = 0; i < 16; i++){
            System.out.print(RAM[indexEA][i]);
        }
        System.out.println();
    }

    public static String EA(String IX, String I, String Address) {
        int indexIX = Integer.parseInt(IX,2);
        int indexI = Integer.parseInt(I,2);
        int indexAddress = Integer.parseInt(Address,2);
        // System.out.println("indexAddress: " + indexAddress);
        if (indexI == 0){
            System.out.println("indexI = 0");
            
            // No Indirect
            //      No Index: RAM[Normal Address]
            //      Yes Index: RAM[Index + Address]
            // 
            // Yes Indirect
            //      No Index: RAM[RAM[Normal Address]]
            //      Yes Index:RAM[RAM[Index + Address]]
            // 
            
            if (indexIX == 0){
                //EA = contents of the Address field c(Address Field)
                // String stringRAM = String.valueOf(indexAddress);
                // System.out.println("stringRAM: " + stringRAM);
                System.out.println("indexIX = 0");
                String temp = "";
                for (int i = 12; i > Address.length(); i--){
                    temp += "0";
                }
                temp += Address;
                System.out.println("EA Return: " + temp);              
                return temp;
                // return stringRAM;
            }
            else if (indexIX == 1 || indexIX == 2 || indexIX == 3){
                System.out.println("indexIX = 1||2||3");
                //EA = c(IX) + c(Address Field)
                // String stringRAM = String.valueOf(indexAddress);
                String temp = "";
                for (int i = 12; i > Address.length(); i--){
                    temp += "0";
                }
                temp += Address;
                System.out.println("temp: " + temp);
                String stringIX = String.valueOf(XR[indexIX]);
                System.out.println("stringIX: " + stringIX);
                int tempAddress = Integer.parseInt(temp,2);
                int tempIX = Integer.parseInt(stringIX,2);
                // CONVERT TO INTS, ADD, CONVERT BACK
                // Adding the VALUE held in the registers
                int tempTotal = tempAddress + tempIX;
                String tempFinal = Integer.toBinaryString(tempTotal);
                System.out.println("tempFinal: " + tempFinal);
                temp = "";
                for (int i = 12; i > tempFinal.length(); i--){
                    temp += "0";
                }
                temp += tempFinal;
                System.out.println("EA Return: " + temp);           
                return temp;
            }
        }
        if (indexI == 1){
            System.out.println("indexI = 1");
            if (indexIX == 0){
                System.out.println("indexIX = 0");
                //EA = c(c(Address Field))
                String Index = String.valueOf(RAM[indexAddress]);
                System.out.println("EA Return: " + Index);
                return Index;
            }
            else if (indexIX == 1 || indexIX == 2 || indexIX == 3){
                System.out.println("indexIX = 1||2||3");
                //EA = c(c(IX) + c(Address Field))
                String temp = "";
                for (int i = 12; i > Address.length(); i--){
                    temp += "0";
                }
                temp += Address;
                System.out.println("temp: " + temp);
                String stringIX = String.valueOf(XR[indexIX]);
                System.out.println("stringIX: " + stringIX);
                int tempAddress = Integer.parseInt(temp,2);
                int tempIX = Integer.parseInt(stringIX,2);
                // CONVERT TO INTS, ADD, CONVERT BACK
                // Adding the VALUE held in the registers
                int tempTotal = tempAddress + tempIX;
                System.out.println("tempTotal: " + tempTotal);         
                String Index = String.valueOf(RAM[tempTotal]);
                System.out.println("EA Return: " + Index);
                return Index;
            }
        }
        System.out.println("EA Failure");
        return "";
    }
    ////////////////////////////////Part-2----START///////////////////////////////////////////


    public static void JZ(String R, String IX, String I, String Address){
        int indexR = Integer.parseInt(R,2);

        if(indexR == 0)
        {
            PC = EA(IX, I, Address).toCharArray();
            System.out.println(String.format("~~~JZ Running~~~\n GPR %d is zero, jump to %H ", indexR, PC));
        }
        else {
            PCincrement();
            System.out.println(String.format("~~~JZ Running~~~\n GPR %d is not zero, do not jump", indexR));
        }
    }
    public static void JNE(String R, String IX, String I, String Address){
        int indexR = Integer.parseInt(R,2);
        if(indexR != 0)
        {
            PC = EA(IX, I, Address).toCharArray();
            System.out.println(String.format("~~~JNE Running~~~\n GPR %d is not zero, jump to %H ", indexR, PC));
        }
        else {
            PCincrement();
            System.out.println(String.format("~~~JNE Running~~~\n GPR %d is zero, do not jump", indexR));

        }
    }
    public static void JCC(String CC, String IX, String I, String Address){
        int indexR = Integer.parseInt(R(input));//check
        int binNum = 1<<indexR;
        int cc = Integer.parseInt(CC,2);
        if((cc & binNum) == 1)
        {
            PC = EA(IX, I, Address).toCharArray();
            System.out.println(String.format("Running JCC\n  CC: %d equals to required CC: %d jump to %H", cc, I, PC));
        }
        else{
            PCincrement();
            System.out.println(String.format("Running JCC\n  CC: %d does not equals to required CC: %d jump to %H", cc, I, PC));
        }
    }
    public static void JMA(String IX, String I, String Address){
        PC = EA(IX,I,Address).toCharArray();
        System.out.println(String.format("Running JMA\n  Jump to %H", PC));
    }
    public static void JSR(String IX, String I, String Address){
        PCincrement();
        GPR[3] = PC;
        PC = EA(IX, I, Address).toCharArray();
        System.out.println(String.format("Running JSR\n  Jump to %H, current Args at %H", PC, GPR[0]));

    }
    public static void RFS(String input){//check
        GPR[0] = Address(input).toCharArray();
        PC = Arrays.toString(GPR[3]).toCharArray();
        System.out.println(String.format("Running RFS\n  Return to %H, return value at %H", GPR[3], GPR[0]));
    }
    public static void SOB(String R, String IX, String I, String Address){
        int indexR = Integer.parseInt(R,2);
        R = String.valueOf(indexR-1);
        int newR = Integer.parseInt(R,2);
        if(newR>0) {
            PC = EA(IX, I, Address).toCharArray();
            System.out.println(String.format("GPR%d: %d, jump to %H", I, GPR[newR], PC));
        }
        else {
            PCincrement();
            System.out.println(String.format("GPR%d: %d, not jump to %H", I, GPR[newR]));

        }
    }
    public static void JGE(String R, String IX, String I, String Address){
        int indexR = Integer.parseInt(R,2);
        if(indexR>=0)
        {
            PC = EA(IX, I, Address).toCharArray();
            System.out.println(String.format("Running JGE\n  GRP%d: %d, jump to %H", GPR[indexR], PC));
        }
        else{
            PCincrement();
            System.out.println(String.format("Running JGE\n  GRP%d: %d, not jump to %H", GPR[indexR]));
        }
    }
    public static void AMR(String R, String IX, String I, String Address){
        int indexR = Integer.parseInt(R,2);
        int EA = Integer.parseInt(EA(IX,I,Address),2);
        R = String.valueOf(indexR + EA);
        PCincrement();
        int val = Integer.parseInt(String.valueOf(GPR[indexR]),2);
        if(val > 65535){
            val -= 65536;
            int cc = Integer.parseInt(String.valueOf(CC),2);
            cc |= 1;
            System.out.println("Overflow!");
        }
        System.out.println(String.format("  Add %d at %H to GPR%d, result is %d",RAM[EA], EA, R, val ));
    }
    public static void SMR(String R, String IX, String I, String Address){
        int indexR = Integer.parseInt(R,2);
        int EA = Integer.parseInt(EA(IX,I,Address),2);
        R = String.valueOf(indexR - EA);
        PCincrement();
        int val = Integer.parseInt(String.valueOf(GPR[indexR]),2);
        if(val < 0){
            val += 65536;
            int cc = Integer.parseInt(String.valueOf(CC),2);
            cc |= 2;
            System.out.println("Underflow!");
        }
        System.out.println(String.format("  Sub %d at %H to GPR%d, result is %d",RAM[EA], EA, R, val ));


    }
    public static void AIR(String R, String input ){
        int indexR = Integer.parseInt(R,2);
        int Immed = Integer.parseInt(Address(input));//check
        R = String.valueOf(indexR+Immed);
        PCincrement();
        int ea = Integer.parseInt(EA(IX(input),I(input),Address(input)),2);//check
        int val = Integer.parseInt(String.valueOf(GPR[indexR]),2);
        val += ea;
        if(val > 65535){
            val -= 65536;
            int cc = Integer.parseInt(String.valueOf(CC),2);
            cc |= 1;//check cc
            System.out.println("~~~Overflow~~~");
        }

    }
    public static void SIR(String R, String input) {
        int indexR = Integer.parseInt(R, 2);
        int Immed = Integer.parseInt(Address(input));//check
        R = String.valueOf(indexR - Immed);
        PCincrement();
        int ea = Integer.parseInt(EA(IX(input), I(input), Address(input)), 2);//check
        int val = Integer.parseInt(String.valueOf(GPR[indexR]), 2);
        val -= ea;
        if (val > 65535) {
            val -= 65536;
            int cc = Integer.parseInt(String.valueOf(CC), 2);
            cc |= 1;//check cc
            System.out.println("~~~Underflow~~~");

        }
    }
    private static void MLT(String Rx, String Ry){
        int rx = Integer.parseInt(Rx,2);
        int ry = Integer.parseInt(Ry,2);
        if(rx == 0 || rx == 2 && ry == 0 || ry == 2){
            long multi = Integer.parseInt(Rx) * Integer.parseInt(Ry);
            String multStr = String.format("%32s", Long.toBinaryString(multi)).replace(' ', '0');

            String h = multStr.substring(0,16);
            String l = multStr.substring(16,32);

            rx = Integer.parseInt(h,2);
            ry = Integer.parseInt(l,2);
            System.out.println(String.format("  MLT r%d with r%d, result is %d %s %s %s", rx, ry, multi, multStr, h, l));
        }
    }
    public static void DVD(String Rx, String Ry){
        int rx = Integer.parseInt(Rx,2);
        int ry = Integer.parseInt(Ry,2);
        if(rx == 0 || rx == 2 && ry == 0 || ry == 2){
            if(ry == 0) {
                int cc = Integer.parseInt(String.valueOf(CC),2);
                cc |= 4;
            }
            int quotient = rx/ry;
            int remainder = rx%ry;
            Rx = String.valueOf(quotient);
            Ry = String.valueOf(remainder);
            System.out.println(String.format(" DVD r%d with r%d, quotient is %d, remainder is %d", Rx, Ry, quotient, remainder));
        }

    }
    public static void TRR(String Rx, String Ry){
        int rx = Integer.parseInt(Rx,2);
        int ry = Integer.parseInt(Ry,2);
        if(GPR[rx]==GPR[ry]){
            int cc = Integer.parseInt(String.valueOf(CC),2);
            cc |= 8;
            System.out.println(String.format("r%d equals to r%d", rx, ry));

        }
    }
    public static void AND(String Rx, String Ry){
        int rx = Integer.parseInt(Rx,2);
        int ry = Integer.parseInt(Ry,2);
        rx &= ry;
        System.out.println(String.format("  r%d AND r%d", rx, ry));

    }
    public static void ORR(String Rx, String Ry){
        int rx = Integer.parseInt(Rx,2);
        int ry = Integer.parseInt(Ry,2);
        rx |= ry;
        System.out.println(String.format("  r%d ORR r%d", rx, ry));
    }
    public static void NOT(String input){
        String NOT = "";
        for (int i = 8; i < 10; i++){
            input += ~(input.charAt(i));
        }
        System.out.println("NOT: " + NOT);
        int rx = Integer.parseInt(input);
        System.out.println(String.format("  NOT r%d", rx));

    }
        public static int opcode(String input) {
            String opcode = "";
            for (int i = 0; i < 6; i++){
                opcode += input.charAt(i);
            }
            String getMAR = "";
            for (int i = 0; i < MAR.length; i++){
                getMAR += MAR[i];
            }
            int intMAR = Integer.parseInt(getMAR,2);
            System.out.print("~Instruction #");
            System.out.print((intMAR-5)+ "~");
            System.out.println();
            System.out.println("Opcode: " + opcode);
            int intOpcode = Integer.parseInt(opcode,2);
            // System.out.println("intOpcode: " + intOpcode);
            if (intOpcode == 0){
                //Halt
            }
            if (intOpcode == 1){
                LDR(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ LDR RAN ~~~ ");
            }
            if (intOpcode == 2){
                STR(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ STR RAN ~~~ ");
            }
            if (intOpcode == 3){
                LDA(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ LDA RAN ~~~ ");
            }
            if (intOpcode == 41){
                LDX(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ LDX RAN ~~~ ");
            }
            if (intOpcode == 42){
                STX(R(input), IX(input), I(input), Address(input));
                System.out.println("~~ STX RAN ~~~ ");
            }
            ////////////////////////////////Part-2----START///////////////////////////////////////////
            if (intOpcode == 10){
                JZ(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ JZ RAN ~~~");
            }
            if (intOpcode == 11){
                JNE(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ JNE RAN ~~~");
            }
            if (intOpcode == 12){
                JCC(Arrays.toString(CC), IX(input), I(input), Address(input));//check
                System.out.println("~~~ JCC RAN ~~~");
            }
            if (intOpcode == 13){
                JMA(IX(input), I(input), Address(input));
                System.out.println("~~~ JMA RAN ~~~");
            }
            if (intOpcode == 14){
                JSR(IX(input), I(input), Address(input));
                System.out.println("~~~ JSR RAN ~~~");
            }
            if (intOpcode == 15){
                RFS(EA(IX(input), I(input), Address(input)));
                System.out.println("~~~ RFS RAN ~~~");
            }
            if (intOpcode == 16){
                SOB(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ SOB RAN ~~~");
            }
            if (intOpcode == 17){
                JGE(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ JGE RAN ~~~");
            }
            if (intOpcode == 04){
                AMR(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ AMR RAN ~~~");
            }
            if (intOpcode == 05){
                SMR(R(input), IX(input), I(input), Address(input));
                System.out.println("~~~ SMR RAN ~~~");
            }
            if (intOpcode == 06){
                AIR(R(input),Immed );//check
                System.out.println("~~~ AIR RAN ~~~");
            }
            if (intOpcode == 07){
                SIR(R(input), Immed);//check
                System.out.println("~~~ SIR RAN ~~~");
            }
            if (intOpcode == 20){
                MLT(R(input), IX(input));
                System.out.println("~~~ MLT RAN ~~~");
            }
            if (intOpcode == 21){
                DVD(R(input), IX(input));
                System.out.println("~~~ DVD RAN ~~~");
            }
            if (intOpcode == 22){
                TRR(R(input), IX(input));
                System.out.println("~~~ TRR RAN ~~~");
            }
            if (intOpcode == 23){
                AND(R(input), IX(input));
                System.out.println("~~~ AND RAN ~~~");
            }
            if (intOpcode == 24){
                ORR(R(input), IX(input));
                System.out.println("~~~ ORR RAN ~~~");
            }
            if (intOpcode == 25){
                NOT(R(input));
                System.out.println("~~~ NOT RAN ~~~");
            }
            ////////////////////////////////Part-2----END///////////////////////////////////////////
            return intOpcode;
        }
    ////////////////////////////////Part-2----END///////////////////////////////////////////


    // General Purpose Registers (16 Long)
    public void loadGPR(String input, int number){
        for (int i = 0; i < GPR[number].length; i++){
                GPR[number][i] = (input.charAt(i));
        }
    }
    
    // Index Registers (16 Long)
    public void loadXR(String input, int number){
        for (int i = 0; i < XR[number].length; i++){
                XR[number][i] = (input.charAt(i));
        }
    }
    
    // PC - 12 bits
    public void loadPC(String input){
        for (int i = 0; i < PC.length; i++){
            PC[i] = (input.charAt(i));
    }
    }

    // MAR - 12 bits
    // Memory Address Register: holds the address of the word to be fetched from memory
    public void loadMAR(String input){
        for (int i = 0; i < MAR.length; i++){
            MAR[i] = (input.charAt(i));
        }
    }

    // MBR - 16 bits
    // Memory Buffer Register: holds the word just fetched from or the word to be /last stored into memory
    public void loadMBR(String input){
        for (int i = 0; i < MBR.length; i++){
            MBR[i] = (input.charAt(i));
        }
    }

    public void refresh(){
    
        showGPR0 = "";
        showGPR1 = "";
        showGPR2 = "";
        showGPR3 = "";
        showXR0 = "";
        showXR1 = "";
        showXR2 = "";
        showPC = "";
        showCC = "";
        showMAR = "";
        showMBR = "";
        showIR = "";
        showMFR = "";

        // General Purpose Registers (16 Long)
        for (int i = 0; i < GPR[0].length; i++){
            showGPR0 += GPR[0][i];
        }
        for (int i = 0; i < GPR[1].length; i++){
            showGPR1 += GPR[1][i];
        }
        for (int i = 0; i < GPR[2].length; i++){
            showGPR2 += GPR[2][i];
        }
        for (int i = 0; i < GPR[3].length; i++){
            showGPR3 += GPR[3][i];
        }
        // Index Registers (16 Long)
        for (int i = 0; i < XR[0].length; i++){
            showXR0 += XR[1][i];
        }
        for (int i = 0; i < XR[1].length; i++){
            showXR1 += XR[2][i];
        }
        for (int i = 0; i < XR[2].length; i++){
            showXR2 += XR[3][i];
        }
        // PC - 12 bits
        for (int i = 0; i < PC.length; i++){
            showPC += PC[i];
        }
        // CC - 4 bits
        for (int i = 0; i < CC.length; i++){
            showCC += CC[i];
        }
        // MAR - 12 bits
        // Memory Address Register: holds the address of the word to be fetched from memory
        for (int i = 0; i < MAR.length; i++){
            showMAR += MAR[i];
        }
        // MBR - 16 bits
        // Memory Buffer Register: holds the word just fetched from or the word to be /last stored into memory
        for (int i = 0; i < MBR.length; i++){
            showMBR += MBR[i];
        }
        // IR - 12 bits
        for (int i = 0; i < IR.length; i++){
            showIR += IR[i];
        }
        // MFR - 12 bits
        for (int i = 0; i < MFR.length; i++){
            showMFR += MFR[i];
        }
    }



    class ConditionCode {
        private int OVERFLOW = 0;
        private int UNDERFLOW = 0;
        private int DIVZERO = 0;
        private int EQUALORNOT = 0;


        public void OVERFLOW() {
            OVERFLOW = 1;
        }

        public void UNDERFLOW() {
            UNDERFLOW = 1;
        }

        public void DIVZERO() {
            DIVZERO = 1;
        }

        public void EQUALORNOT() {
            EQUALORNOT = 1;
        }

        public void resetCC() {
            OVERFLOW = 0;
            UNDERFLOW = 0;
            DIVZERO = 0;
            EQUALORNOT = 0;
        }
    }


}
