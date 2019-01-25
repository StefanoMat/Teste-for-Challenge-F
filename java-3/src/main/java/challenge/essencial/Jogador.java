package challenge.essencial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Jogador {
    private String nationality;
    private String club;
    private String fullName;
    private Integer age;
    private Double buyRealese;
    private Double salary;
    private LocalDate birthDate;



    public Jogador(String fullName, String club, Integer age, LocalDate birthDate, String nationality, Double salary, Double buyRealese) {
        setFullName(fullName);
        setClub(club);
        setAge(age);
        setBirthDate(birthDate);
        setNationality(nationality);
        setSalary(salary);
        setBuyRealese(buyRealese);
    }

    public String getNationality(){
        return nationality;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }


    public String getClub(){
        return club;
    }

    public void setClub(String club){
        this.club = club;
    }


    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }


    public Double getBuyRealese(){
        return buyRealese;
    }

    public void setBuyRealese(Double buyRealese){
        this.buyRealese = buyRealese;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }


    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }



    public static final void carregarJogador(List<Jogador> list) throws IOException {

        // write your code
        ClassLoader classLoader = Jogador.class.getClassLoader();
        File linkForRead = new File(classLoader.getResource("data.csv").getFile());

        BufferedReader buffer;
        String line = "";
        System.out.println(linkForRead);
        String[] fields;

        buffer = new BufferedReader(new FileReader(linkForRead));
        buffer.readLine();
        while ((line = buffer.readLine()) != null) {

            fields = line.split(",");

            if(fields[18].isEmpty()){
                fields[18] = "000.0";
            }
            list.add(new Jogador(fields[2], fields[3],
                    Integer.parseInt(fields[6]),
                    LocalDate.parse(fields[8]), fields[14],
                    Double.parseDouble(fields[17]),
                    Double.parseDouble(fields[18])));

        }
    }








}
