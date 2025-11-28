package com.bazar.stands.service;

import java.util.Scanner;

public class AuthService {

    public void cargarAdmins() {
        // Más adelante puedes cargar usuarios desde archivo.
        // Por ahora no hace nada.
    }

    public boolean login(Scanner scanner) {
        // Versión sencilla: siempre deja entrar, solo simula login
        System.out.println("=== Login (modo simple) ===");
        System.out.print("Usuario: ");
        String user = scanner.nextLine();
        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        System.out.println("Login correcto (simulado) para usuario: " + user);
        return true;
    }
}
