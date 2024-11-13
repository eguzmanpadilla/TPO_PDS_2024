package org.example.model;

  public enum ZonaPrecio {
    PLATEA(500),
    PALCO_ALTO(1000),
    PALCO_BAJO(1500),
    CAZUELA(2000),
    TERTULIA(2500),
    PARAISO(3000);

    private final int precio;

    ZonaPrecio(int precio) {
      this.precio = precio;
    }

    public int getPrecio() {
      return precio;
    }
  }