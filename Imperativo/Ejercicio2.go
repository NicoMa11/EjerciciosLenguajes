package main

import (
	"fmt"
	"sort"
	"strings"
)

type infoCliente struct {
	nombre string
	correo string
	edad   int32
}

type listaClientes []infoCliente

func (lc *listaClientes) agregarCliente(nombre, correo string, edad int32) {
	*lc = append(*lc, infoCliente{nombre, correo, edad})
}

func map1[P1, P2 any](list []P1, f func(P1) P2) []P2 {
	mapped := make([]P2, len(list))

	for i, e := range list {
		mapped[i] = f(e)
	}
	return mapped
}

func filter[P1 any](list []P1, f func(P1) bool) []P1 {
	filtered := make([]P1, 0)

	for _, element := range list {
		if f(element) {
			filtered = append(filtered, element)
		}
	}
	return filtered
}

func reduce(list []any) any {
	var result int32 = 0
	for _, v := range list {
		result += v.(int32)
	}
	return result
}

func listaClientes_ApellidoEnCorreo(clientes *listaClientes) listaClientes {
	return filter(*clientes, func(c infoCliente) bool {
		return strings.Contains(strings.ToLower(c.correo), strings.ToLower(strings.Split(c.nombre, " ")[1]))
	})
}

func cantidadCorreosCostaRica(clientes *listaClientes) int32 {
	correosCr := filter(*clientes, func(c infoCliente) bool {
		return strings.HasSuffix(strings.ToLower(c.correo), ".cr")
	})
	return int32(len(correosCr))
}

func clientesSugerenciasCorreos(clientes *listaClientes) map[string]string {
	sugerencias := make(map[string]string)

	for _, c := range *clientes {
		nombre := strings.Split(c.nombre, " ")
		nombreCompleto := strings.Join(nombre, ".")
		dominio := strings.Split(c.correo, "@")[1]
		nuevoCorreo := fmt.Sprintf("%s@%s", strings.ToLower(nombreCompleto), dominio)

		if !strings.Contains(strings.ToLower(c.correo), strings.ToLower(nombre[0])) &&
			!strings.Contains(strings.ToLower(c.correo), strings.ToLower(nombre[1])) {
			sugerencias[c.nombre] = nuevoCorreo
		}
	}

	return sugerencias
}

func correosOrdenadosAlfabeticos(clientes *listaClientes) []string {
	correos := make([]string, 0)

	for _, c := range *clientes {
		correos = append(correos, c.correo)
	}

	sort.Strings(correos)

	return correos
}

func main() {
	var listaClientes listaClientes

	listaClientes.agregarCliente("Oscar Viquez", "oviquez@tec.ac.cr", 44)
	listaClientes.agregarCliente("Pedro Perez", "elsegundo@gmail.com", 30)
	listaClientes.agregarCliente("Maria Lopez", "mlopez@hotmail.com", 18)
	listaClientes.agregarCliente("Juan Rodriguez", "jrodriguez@gmail.com", 25)
	listaClientes.agregarCliente("Luisa Gonzalez", "muyseguro@tec.ac.cr", 67)
	listaClientes.agregarCliente("Marco Rojas", "marquito@hotmail.com", 47)
	listaClientes.agregarCliente("Marta Saborio", "msaborio@gmail.com", 33)
	listaClientes.agregarCliente("Camila Segura", "csegura@ice.co.cr", 19)
	listaClientes.agregarCliente("Fernando Rojas", "frojas@estado.gov", 27)
	listaClientes.agregarCliente("Rosa Ramirez", "risuenna@gmail.com", 50)
	listaClientes.agregarCliente("Carlos Araya", "carlos.araya@gmail.com", 40)
	listaClientes.agregarCliente("Laura Jimenez", "laurajimenez@yahoo.com", 22)
	listaClientes.agregarCliente("Roberto Solis", "robSs@hotmail.com", 35)
	listaClientes.agregarCliente("Ana Martinez", "anamartinez@tec.ac.cr", 60)
	listaClientes.agregarCliente("David Guzman", "davidguz@outlook.com", 29)
	listaClientes.agregarCliente("Elena Rojas", "erojas@gmail.com", 55)
	listaClientes.agregarCliente("Sofia Herrera", "sofhe@gmail.com", 28)

	clientesFiltrados := listaClientes_ApellidoEnCorreo(&listaClientes)

	// Imprimir la lista de clientes con el apellido en el correo
	fmt.Printf("\nEjercicio 2: Clientes con el apellido en el correo:\n")
	for _, cliente := range clientesFiltrados {
		fmt.Printf("Nombre: %s, Correo: %s, Edad: %d\n", cliente.nombre, cliente.correo, cliente.edad)
	}

	//Imprimir la cantidad de correos con .cr
	cantidad := cantidadCorreosCostaRica(&listaClientes)
	fmt.Printf("\nEjercicio 3: Cantidad de clientes con correos de Costa Rica: %d\n", cantidad)

	// Imprimir las sugerencias de correo
	sugerencias := clientesSugerenciasCorreos(&listaClientes)
	fmt.Println("\nEjercicio 4: Sugerencias de correo:")
	for nombre, correo := range sugerencias {
		fmt.Printf("Cliente: %s, Nuevo Correo: %s\n", nombre, correo)
	}

	// Imprimir la lista de correos ordenados alfabéticamente
	correosOrdenados := correosOrdenadosAlfabeticos(&listaClientes)
	fmt.Println("\nEjercicio 5: Correos ordenados alfabéticamente:")
	for _, correo := range correosOrdenados {
		fmt.Println(correo)
	}
}
