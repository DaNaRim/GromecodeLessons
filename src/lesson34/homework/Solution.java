package lesson34.homework;

import java.io.*;

public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception{
        validate(fileFromPath, fileToPath);
        deleteFileContent(fileFromPath);
        writeFile(fileToPath, readFromFile(fileFromPath));
    }

    private static void deleteFileContent(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            res.replace(0, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Delete from file " + path + "failed");
        }
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }
        return res;
    }

    private static void writeFile(String path, StringBuffer contentToWriter) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            if (readFromFile(path).toString().equals("")) bufferedWriter.append("\n");

            bufferedWriter.append(contentToWriter);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permissions to read");
        }

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permissions to written");
        }
    }
}
