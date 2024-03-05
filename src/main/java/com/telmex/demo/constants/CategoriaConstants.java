package com.telmex.demo.constants;

public class CategoriaConstants {

    public final static String ROL_PARAM_LIST = "idRol";

    public final static String GET_CATEGORY_BY_ROL = "SELECT DISTINCT c FROM UserCategory c INNER JOIN c.functions uf INNER JOIN uf.permissions p INNER JOIN p.rol ur WHERE ur.idRole IN :"+ROL_PARAM_LIST+" ORDER BY c.orden";
}
