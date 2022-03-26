//package com.example.MyBookShopApp.config;
//
//import com.example.MyBookShopApp.data.BookRepository;
//import com.example.MyBookShopApp.data.TestEntity;
//import com.example.MyBookShopApp.data.TestEntityCrudRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.logging.Logger;
//
//@Configuration
//public class CommandLineRunnerImpl implements CommandLineRunner {
//
//    TestEntityCrudRepository testEntityCrudRepository;
//    BookRepository bookRepository;
//
//    @Autowired
//    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository, BookRepository bookRepository) {
//        this.testEntityCrudRepository = testEntityCrudRepository;
//        this.bookRepository = bookRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//        for (int i = 0; i < 5; i++) {
//            createTestEntity(new TestEntity());
//        }
//
//        TestEntity readTestEntity = readTestEntityById(3L);
//        if (readTestEntity != null) {
//            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read" + readTestEntity);
//        }else {
//            throw new NullPointerException();
//        }
//
//        TestEntity updatedTestEntity = updateTestEntityById(6L);
//        if (updatedTestEntity != null) {
//            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update" + updatedTestEntity);
//        }else {
//            throw new NullPointerException();
//        }
//
////        deleteTestEntityById(5L);
//
//        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBooksByAuthor_FirstName("Fan").toString());
//        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.customFindAllBooks().toString());
//    }
//
//    private void createTestEntity(TestEntity entity) {
//        entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
//        testEntityCrudRepository.save(entity);
//    }
//
//    private TestEntity readTestEntityById(Long id) {
//        return testEntityCrudRepository.findById(id).get();
//    }
//
//    private TestEntity updateTestEntityById(Long id) {
//        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
//        testEntity.setData("NEW DATA");
//        testEntityCrudRepository.save(testEntity);
//        return testEntity;
//    }
//
//    private void deleteTestEntityById(Long id) {
//        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
//        testEntityCrudRepository.delete(testEntity);
//    }
//}
