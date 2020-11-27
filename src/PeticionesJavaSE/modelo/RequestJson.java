/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeticionesJavaSE.modelo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestJson {

@SerializedName("name")
@Expose
private String name;
@SerializedName("job")
@Expose
private String job;

/**
* No args constructor for use in serialization
*
*/
public RequestJson() {
}

/**
*
* @param name
* @param job
*/
public RequestJson(String name, String job) {
super();
this.name = name;
this.job = job;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getJob() {
return job;
}

public void setJob(String job) {
this.job = job;
}

}