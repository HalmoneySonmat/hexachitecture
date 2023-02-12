package io.sample.memorise.hexachitecture.adaptors.presentation.service.commands;

public interface ApiCommand {

    void setRequestDto(String requestBody);

    void execute();

    String getResponse();
}
