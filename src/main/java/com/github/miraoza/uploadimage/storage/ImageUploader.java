package com.github.miraoza.uploadimage.storage;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploader {
    public static Path salvarImagem(String uploadDir, MultipartFile file) throws Exception {
        // Verificando se um arquivo foi enviado
        if(file == null) {
            throw new RuntimeException("Um arquivo precisa ser enviado para ser salvo."); // Caso não seja, enviar um erro
        }

        // Informações da imagem
        String fileName   = file.getOriginalFilename(); // Nome do arquvi
        String fileExt    = getFileExt(fileName);       // Extensão do arquivo
        byte[] bytes      = file.getBytes();            // Transformando imagem em array de bytes
        Path   uploadPath = Paths.get(uploadDir);

        // Verificando se o arquivo enviado é uma mensagem
        if(!verificarImagem(fileExt)) { 
            throw new RuntimeException("O arquivo enviado precisa ser uma imagem."); // Caso não seja, enviar um erro
        }

        // Verificando se o destino para upload do arquivo não existe
        if(!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath); // Caso não exista, criar
        }

        uploadPath = Paths.get(uploadPath + "/" + gerarNomeDoArquivo(uploadDir, fileExt)); // Gerando caminho
        Files.write(uploadPath, bytes); // Salvando imagem

        // Retornando arquivo
        return uploadPath;
    }

    // Método para verificar se arquivo é uma imagem
    public static boolean verificarImagem(String fileExt) {
        return (fileExt.equals(".png") || fileExt.equals(".jpg") || fileExt.equals(".jpeg") || fileExt.equals(".webp"));
    }

    // Pegando extensão da imagem
    public static String getFileExt(String fileName) {
        int i = fileName.lastIndexOf('.');
        return fileName.substring(i);
    }

    // Método para gerar um nome para o arquivo para evitar duplicação de nomes
    public static String gerarNomeDoArquivo(String uploadDir, String fileExt) {
        return (new File(uploadDir).list().length) + fileExt;
    }
}
