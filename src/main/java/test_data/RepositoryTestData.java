package test_data;

import com.github.javafaker.Faker;
import payloads.DifferentDataTypeRepository;
import payloads.InvalidRepository;
import payloads.Repository;

import static utils.constants.SpecialStrings.*;

public class RepositoryTestData {

    private Faker faker = new Faker();

    public Repository getRepository() {
        return new Repository(faker.name().username(), faker.lorem().sentence());
    }

    public Repository getRepositoryWithEmptyName() {
        return new Repository("", faker.lorem().sentence());
    }

    public Repository getRepositoryWithEmptyDescription() {
        return new Repository(faker.name().username(), "");
    }

    public Repository getRepositoryWithEmptyNameAndDescription() {
        return new Repository("", "");
    }

    public Repository getRepositoryWithNullValues() {
        return new Repository(null, null);
    }

    public Repository getRepositoryWithSpecificName(String repositoryName) {
        return new Repository(repositoryName, faker.lorem().sentence());
    }

    public Repository getRepositoryWithSpecificNameAndNoDescription(String repositoryName) {
        return new Repository(repositoryName, null);
    }

    public Repository getRepositoryWithSpecificDescription(String repositoryDescription) {
        return new Repository(faker.name().username(), repositoryDescription);
    }

    public Repository getRepositoryWithSpecificNameAndDescription(String repositoryName, String repositoryDescription) {
        return new Repository(repositoryName, repositoryDescription);
    }

    public DifferentDataTypeRepository getRepositoryWithNumericAndBoolean() {
        return new DifferentDataTypeRepository(faker.number().numberBetween(1, 1000), false);
    }

    public InvalidRepository getInvalidRepository() {
        return new InvalidRepository();
    }

    public Repository getRepositoryWithSpecialSymbols() {
        return new Repository(SPECIAL_CHARS_STRING, SPECIAL_CHARS_STRING);
    }

    public Repository getRepositoryWithSpacesInName() {
        return new Repository(STRING_WITH_SPACES, faker.lorem().sentence());
    }

    public Repository getRepositoryWithScriptName() {
        return new Repository(SCRIPT_STRING);
    }

    public Repository getRepositoryWithStrippedScriptName() {
        return new Repository(STRIPPED_SCRIPT_STRING);
    }

    public Repository getRepositoryWithOneSymbol() {
        return new Repository(faker.lorem().characters(1), faker.lorem().characters(1));
    }

    public Repository getRepositoryWithLongName() {
        return new Repository(faker.lorem().characters(1000), faker.lorem().sentence());
    }

    public Repository getRepositoryWithLongDescription() {
        return new Repository(faker.name().username(), faker.lorem().paragraph());
    }

    public Repository getRepositoryWithCapitalLettersOnly() {
        return new Repository(faker.name().username().toUpperCase(), faker.lorem().sentence().toUpperCase());
    }

    public Repository getRepositoryWithGermanSymbols() {
        return new Repository(GERMAN_ALPHABET_STRING, GERMAN_ALPHABET_STRING);
    }

    public Repository getRepositoryWithArabicSymbols() {
        return new Repository(ARABIC_STRING, ARABIC_STRING);
    }

    public Repository getRepositoryWithChineseSymbols() {
        return new Repository(CHINESE_STRING, CHINESE_STRING);
    }

    public Repository getRepositoryWithEmojiSymbols() {
        return new Repository(EMOJI_STRING, EMOJI_STRING);
    }

    public String getRepositoryName() {
        return faker.name().username();
    }

    public String getRepositoryDescription() {
        return faker.lorem().sentence();
    }
}
