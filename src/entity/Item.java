package entity;

public class Item
{
    //ATRIBUTOS 

    private String nombre;
    private Integer cantidad;
    private Integer precio_unitario;
    private float precio;

    public Item(String nombre, Integer cantidad, Integer precio_unitario, float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.precio = precio;
    }

    public Item(String nombre, Integer cantidad, Integer precio_unitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.precio = this.precio_unitario*this.cantidad;
    }
    
    public Item(){
    }

    //ACCESORS
    
    //GETTERS
    
    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getPrecio_unitario() {
        return precio_unitario;
    }

    public float getPrecio() {
        return precio;
    }

    //SETTERS
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio_unitario(Integer precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
