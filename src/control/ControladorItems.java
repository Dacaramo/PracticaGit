package control;

import java.util.HashMap;
import entity.Item;

public class ControladorItems 
{
    //RELACIONES
    
    private HashMap<String, Item> items = new HashMap<>();
    
    //CONSTRUCTORES    

    public ControladorItems() {
    }
    
    
    //ACCESORS

    //GETTERS
    
    public HashMap<String, Item> getItems() {
        return items;
    }

    //SETTERS
    
    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
    
    //METODOS
    
    public void agregarItem(String nombre, Integer cantidad, Integer precio_unitario)
    {
        Item nuevo = new Item(nombre, cantidad, precio_unitario);
        items.put(nombre, nuevo);
    }
    
    public Item buscarItem(String nombre)
    {
        return items.get(nombre);
    }
    
    public boolean borrarItem(String nombre)
    {
        Item borrado = items.remove(nombre);
        
        if(borrado != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public float calcularSubTotal()
    {
   
        float sub = 0;
        
        for(Item elItem : items.values())
        {
            sub = sub + elItem.getPrecio();
        }
        return sub;
    }
    
    public float calcularIva()
    {
        return ((calcularSubTotal()*16)/100);
    }
    
    public float calcularTotal()
    {
        return (calcularSubTotal()+calcularIva());
    }
}
