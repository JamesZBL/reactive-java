/*
 * Copyright 2019 ZHENG BAO LE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.zbl.reactive.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author ZHENG BAO LE
 * @since 2019-05-01
 */
public class Merge {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> first = Observable.interval(500, TimeUnit.MILLISECONDS);
        Observable<Long> second = Observable.interval(600, TimeUnit.MILLISECONDS);
        Observable<Long> third = Observable.interval(700, TimeUnit.MILLISECONDS);
        first
                .mergeWith(second)
                .mergeWith(third)
                .doOnNext(System.out::println)
                .subscribe();
        Thread.sleep(5_000);
    }
}
